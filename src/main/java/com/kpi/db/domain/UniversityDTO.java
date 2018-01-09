package com.kpi.db.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UniversityDTO {
    long id;
    String title;
}
