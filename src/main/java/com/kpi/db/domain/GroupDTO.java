package com.kpi.db.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDTO {
    private long id;
    private String title;
    private long universityId;
}
