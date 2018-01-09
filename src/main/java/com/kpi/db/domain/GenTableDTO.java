package com.kpi.db.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenTableDTO {
    private long id;
    private String title;
    private String authorName;
    private String viewName;
    private String query;
}
