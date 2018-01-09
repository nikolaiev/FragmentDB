package com.kpi.db.dao;

import static com.epam.charity.jooq.dto.tables.Gentables.GENTABLES;
import static com.kpi.db.domain.City.KHARKIV;
import static com.kpi.db.domain.City.KYIV;
import static com.kpi.db.domain.City.LVIV;

import com.kpi.db.domain.City;
import com.kpi.db.domain.GenTableDTO;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class GenTablesDaoImpl implements GenTablesDao {

    @Autowired
    private Map<City, DSLContext> dslRegistry;

    public List<GenTableDTO> getAllGenTables() {
        List<GenTableDTO> kyivGenTables = fetchAllGenTables(dslRegistry.get(KYIV));
        List<GenTableDTO> lvivGenTables = fetchAllGenTables(dslRegistry.get(LVIV));
        List<GenTableDTO> kharkivGenTables = fetchAllGenTables(dslRegistry.get(KHARKIV));

        return Stream.of(kyivGenTables, lvivGenTables, kharkivGenTables)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


    private List<GenTableDTO> fetchAllGenTables(DSLContext dsl) {
        return dsl.select()
                .from(GENTABLES)
                .fetch()
                .map(this::buildGenTableDTO);
    }

    private GenTableDTO buildGenTableDTO(Record record) {
        return GenTableDTO.builder()
                .authorName(record.get(GENTABLES.AUTHOR_NAME))
                .viewName(record.get(GENTABLES.VIEW_NAME))
                .id(record.get(GENTABLES.ID))
                .title(record.get(GENTABLES.TITLE))
                .build();
    }
}
