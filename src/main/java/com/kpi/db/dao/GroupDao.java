package com.kpi.db.dao;

import java.util.List;

import com.kpi.db.domain.City;
import com.kpi.db.domain.GroupDTO;

public interface GroupDao {
    List<GroupDTO> findByUniversity(City city, long universityId);
}
