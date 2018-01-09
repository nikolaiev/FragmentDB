package com.kpi.db.dao;

import java.util.List;

import com.kpi.db.domain.City;
import com.kpi.db.domain.UniversityDTO;

public interface UniversityDao {
    List<UniversityDTO> findAll(City city);
}
