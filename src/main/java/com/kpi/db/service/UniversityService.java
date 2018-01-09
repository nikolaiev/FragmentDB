package com.kpi.db.service;

import java.util.List;
import java.util.Map;

import com.kpi.db.domain.City;
import com.kpi.db.domain.GroupDTO;
import com.kpi.db.domain.UniversityDTO;

public interface UniversityService {
    Map<UniversityDTO, List<GroupDTO>> getUniversitiesWithGroups(City city);
}
