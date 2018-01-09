package com.kpi.db.dao;

import com.kpi.db.domain.City;
import com.kpi.db.models.ViewModel;

import org.jooq.DSLContext;
import org.jooq.Meta;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.charity.jooq.dto.tables.Gentables.GENTABLES;
import static com.epam.charity.jooq.dto.tables.Group.GROUP;
import static com.epam.charity.jooq.dto.tables.User.USER;
import static com.kpi.db.domain.City.KHARKIV;
import static com.kpi.db.domain.City.KYIV;
import static com.kpi.db.domain.City.LVIV;
import static java.util.Collections.*;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.select;

@Repository
public class TablesDaoImpl implements TablesDao {

    @Autowired
    private Map<City, DSLContext> dslRegistry;

    private static final Map<City, Function<ViewModel, List<Long>>> getGroupsRegistry =
            new HashMap<City, Function<ViewModel, List<Long>>>() {{
                put(KYIV, ViewModel::getKyivGroups);
                put(LVIV, ViewModel::getLvivGroups);
                put(KHARKIV, ViewModel::getKharkivGroups);
            }};

    @Override
    public List<Map<String, Object>> getTableContent(String viewName) {
        List<Map<String, Object>> rowsFirstDB = tryGetTableContent(viewName, dslRegistry.get(KYIV));
        List<Map<String, Object>> rowsSecondDB = tryGetTableContent(viewName, dslRegistry.get(LVIV));
        List<Map<String, Object>> rowsThirdDB = tryGetTableContent(viewName, dslRegistry.get(KHARKIV));

        return Stream.of(rowsFirstDB, rowsSecondDB, rowsThirdDB)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Map<String, Object>> tryGetTableContent(String viewName, DSLContext dsl) {
        List<Map<String, Object>> tableContent = tryFetchTableContent(dsl, viewName);
        return Optional.ofNullable(tableContent).orElse(emptyList());
    }

    private List<Map<String, Object>> tryFetchTableContent(DSLContext dsl, String viewName) {
        return isViewExist(dsl, viewName) ? fetchTableContent(dsl, viewName) : null;
    }

    private boolean isViewExist(DSLContext dsl, String viewName) {
        Meta meta = dsl.meta();
        List<Table<?>> tables = meta.getTables();
        return tables.stream().parallel().anyMatch(t -> t.getName().equals(viewName));
    }

    private List<Map<String, Object>> fetchTableContent(DSLContext dsl, String viewName) {
        return dsl.select().from(name(viewName)).fetchMaps();
    }

    @Override
    public void createTable(ViewModel view) {
        tryCreateConcreteDataSourceTable(view, KYIV);
        tryCreateConcreteDataSourceTable(view, LVIV);
        tryCreateConcreteDataSourceTable(view, KHARKIV);
    }

    private void tryCreateConcreteDataSourceTable(ViewModel view, City city) {
        List<Long> groupIds = getGroupIds(city, view);
        if (groupIds == null) {
            return;
        }

        DSLContext dsl = dslRegistry.get(city);
        createView(dsl, groupIds, view);
    }

    private void createView(DSLContext dsl, List<Long> groupIds, ViewModel view) {
        dsl.createView(view.getName())
                .as(
                        select(USER.ID, USER.NAME, USER.SONAME, USER.BIRTHDATE, GROUP.TITLE)
                                .from(USER)
                                .naturalJoin(GROUP)
                                .where(GROUP.ID.in(groupIds))
                ).execute();
        createViewMetadata(dsl, view);
    }

    private List<Long> getGroupIds(City city, ViewModel view) {
        Function<ViewModel, List<Long>> getGroupsFunction = getGroupsRegistry.get(city);
        return getGroupsFunction.apply(view);
    }

    private void createViewMetadata(DSLContext dsl, ViewModel view) {
        dsl.insertInto(GENTABLES, GENTABLES.TITLE, GENTABLES.AUTHOR_NAME, GENTABLES.VIEW_NAME)
                .values(view.getInfo(), view.getAuthor(), view.getName())
                .execute();
    }
}
