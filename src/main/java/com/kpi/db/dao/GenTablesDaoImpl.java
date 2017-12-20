package com.kpi.db.dao;

import com.epam.charity.jooq.dto.tables.Gentables;
import com.kpi.db.models.GetTableDTO;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GenTablesDaoImpl implements GenTablesDao {

    @Autowired
    DSLContext dslContext;



    public List<GetTableDTO> getAllGenTables(){
        Result<Record> records = this.dslContext.select().from(Gentables.GENTABLES).fetch();

        return records.stream()
                .map(record -> GetTableDTO.builder()
                .authorName(record.get(Gentables.GENTABLES.AUTHOR_NAME))
                .viewName(record.get(Gentables.GENTABLES.VIEW_NAME))
                .id(record.get(Gentables.GENTABLES.ID))
                .query(record.get(Gentables.GENTABLES.QUERY))
                .title(record.get(Gentables.GENTABLES.TITLE))
                .build())
                .collect(Collectors.toList());
    }
}
