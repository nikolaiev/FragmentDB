package com.kpi.db.models;

import java.util.List;

import lombok.Data;

@Data
public class ViewModel {
    private String name;
    private List<Long> kyivGroups;
    private List<Long> lvivGroups;
    private List<Long> kharkivGroups;
    private String author;
    private String info;
}
