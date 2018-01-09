package com.kpi.db.dao;

import static com.epam.charity.jooq.dto.tables.University.UNIVERSITY;
import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpi.db.domain.City;
import com.kpi.db.domain.UniversityDTO;

@Repository
public class UniversityDaoImpl implements UniversityDao {

    @Autowired
    private Map<City, DSLContext> dslRegistry;

    @Override
    public List<UniversityDTO> findAll(City city) {
        DSLContext dsl = dslRegistry.get(city);
        List<UniversityDTO> universities = fetchUniversities(dsl);
        return Optional.ofNullable(universities).orElse(emptyList());
    }

    private List<UniversityDTO> fetchUniversities(DSLContext dsl) {
        return dsl.selectFrom(UNIVERSITY)
                .fetch()
                .map(this::buildUniversityDTO);
    }

    private UniversityDTO buildUniversityDTO(Record record) {
        return UniversityDTO.builder()
                .id(record.get(UNIVERSITY.ID))
                .title(record.get(UNIVERSITY.TITLE))
                .build();
    }
}
