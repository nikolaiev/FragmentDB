package com.kpi.db.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTableDTO {
    private long id;
    private String title;
    private String authorName;
    private String viewName;
    private String query;
}
