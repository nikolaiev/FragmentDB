package com.kpi.db.dao;

import static com.epam.charity.jooq.dto.tables.Group.GROUP;
import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpi.db.domain.GroupDTO;
import com.kpi.db.domain.City;

@Repository
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private Map<City, DSLContext> dslRegistry;

    @Override
    public List<GroupDTO> findByUniversity(City city, long universityId) {
        DSLContext dsl = dslRegistry.get(city);
        List<GroupDTO> groups = fetchByUniversity(dsl, universityId);
        return Optional.ofNullable(groups).orElse(emptyList());
    }

    private List<GroupDTO> fetchByUniversity(DSLContext dsl, long universityId) {
        return dsl.selectFrom(GROUP)
                .where(GROUP.UNIV_ID.eq(universityId))
                .fetch()
                .map(this::buildGroupDTO);
    }

    private GroupDTO buildGroupDTO(Record record) {
        return GroupDTO.builder()
                .id(record.get(GROUP.ID))
                .title(record.get(GROUP.TITLE))
                .universityId(record.get(GROUP.UNIV_ID))
                .build();
    }
}
