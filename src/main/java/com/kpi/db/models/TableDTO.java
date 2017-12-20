package com.kpi.db.models;

import lombok.Builder;
import lombok.Data;
import org.jooq.util.xml.jaxb.Column;

import java.util.List;

@Data
@Builder
public class TableDTO {
    private String name;
    private List<String> columns;
}
