package com.kpi.db.dao;

import com.kpi.db.models.GetTableDTO;

import java.util.List;


public interface GenTablesDao {
    public List<GetTableDTO> getAllGenTables();
}
