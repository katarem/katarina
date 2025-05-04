package io.github.katarem.katarina.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameSearchQueryParams {
    private String type;
    private Long startTime;
    private Long endTime;
    private Integer queue;
    private Integer start;
    private Integer count;
    private String region;
}
