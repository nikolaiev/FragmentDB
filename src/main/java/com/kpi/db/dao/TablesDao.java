package com.kpi.db.dao;

import com.kpi.db.models.ViewModel;

import java.util.List;
import java.util.Map;

public interface TablesDao {
    List<Map<String, Object>> getTableContent(String viewName);
    void createTable(ViewModel view);
}