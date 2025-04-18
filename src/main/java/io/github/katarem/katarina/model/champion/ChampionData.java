package io.github.katarem.katarina.model.champion;

import java.util.Map;

import lombok.Data;

@Data
public class ChampionData {
    private String version;
    private String type;
    private String format;
    private Map<String, ChampionDto> data;
}
