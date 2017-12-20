package com.kpi.db.dao;

import com.kpi.db.models.TableDTO;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.util.xml.jaxb.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;


@Repository
public class TablesDaoImpl implements TablesDao {
    private final String SELECT_FROM_VIEW = "SELECT * FROM public.\"%s\"";
    private final String CREATE_VIEW = "Create view \"%s\" as %s";
    private final String INSERT_VIEW_METAINFO = "INSERT INTO public.\"GenTables\"(\n" +
            "            title, author_name, view_name, query)\n" +
            "    VALUES (?, ?, ?, ?)";
    private final String HIDDEN_TABLE = "GenTables";

    @Autowired
    DSLContext dslContext;

    @Qualifier("lab5_2")
    @Autowired
    private DataSource dataSourceSecond;

    @Autowired
    private DataSource dataSource;

    public List<TableDTO> getAllTables() {

        List<Table<?>> tables = this.dslContext.meta().getTables();

        return tables.stream().filter(table->!table.getName().equals(HIDDEN_TABLE))
                .map(table -> TableDTO.builder()
                        .name(table.getName())
                        .columns(dslContext.informationSchema(table).getColumns()
                                .stream().map(Column::getColumnName).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getTableContent(String viewName) {
        List<Map<String, Object>> rows = new ArrayList<>();

        List<Map<String, Object>> rowsFirstDB = getTableContentConnection(viewName, dataSource);
        List<Map<String, Object>> rowsSecondDB = getTableContentConnection(viewName, dataSourceSecond);

        rows.addAll(rowsFirstDB);
        rows.addAll(rowsSecondDB);


        return rows;
    }

    @Override
    public void createTable(String viewName, String querySelect, String author, String info) {
        createConcreteDataSourceTable(viewName,querySelect,author,info,dataSource);
        createConcreteDataSourceTable(viewName,querySelect,author,info,dataSourceSecond);
    }

    private void createConcreteDataSourceTable(String viewName, String querySelect, String author, String info,DataSource concreteDataSource){
        try (Connection connection = concreteDataSource.getConnection()) {
            //creating table
            Statement statement = connection.createStatement();
            String query = format(CREATE_VIEW, viewName,querySelect);
            System.out.println(query);
            statement.executeUpdate(query);

            //creating metainfo
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_VIEW_METAINFO);
            preparedStatement.setString(1,info);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,viewName);
            preparedStatement.setString(4,querySelect);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<Map<String, Object>> getTableContentConnection(String viewName,DataSource concreteDataSource){
        List<Map<String, Object>> rows = new ArrayList<>();
        try (Connection connection = concreteDataSource.getConnection()) {
            Statement statement = connection.createStatement();

            String query = format(SELECT_FROM_VIEW, viewName);

            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> columns = new LinkedHashMap<>();

                for (int i = 1; i <= columnCount; i++) {
                    columns.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                }

                rows.add(columns);
            }

        } catch (Exception e) {
            //e.printStackTrace();
            throw  new RuntimeException("Query exception");
        }

        return rows;
    }
}
