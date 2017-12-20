package com.kpi.db.dao;

import com.kpi.db.models.TableDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by vladyslav on 19.12.17.
 */
public interface TablesDao {
    List<TableDTO> getAllTables();
    List<Map<String, Object>> getTableContent(String viewName);

    void createTable(String viewName, String query, String author, String info);
}
