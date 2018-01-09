package com.kpi.db.dao;

import com.kpi.db.domain.GenTableDTO;

import java.util.List;

public interface GenTablesDao {
    List<GenTableDTO> getAllGenTables();
}
