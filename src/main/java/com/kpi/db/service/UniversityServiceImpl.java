package com.kpi.db.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpi.db.dao.GroupDao;
import com.kpi.db.dao.UniversityDao;
import com.kpi.db.domain.City;
import com.kpi.db.domain.GroupDTO;
import com.kpi.db.domain.UniversityDTO;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityDao universityDao;
    @Autowired
    private GroupDao groupDao;

    public Map<UniversityDTO, List<GroupDTO>> getUniversitiesWithGroups(City city) {
        List<UniversityDTO> universities = universityDao.findAll(city);
        return universities.stream()
                .parallel()
                .collect(Collectors.toMap(
                        Function.identity(),
                        university -> groupDao.findByUniversity(city, university.getId()))
                );
    }
}
