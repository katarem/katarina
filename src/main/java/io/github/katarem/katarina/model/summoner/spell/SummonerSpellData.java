package io.github.katarem.katarina.model.summoner.spell;

import java.util.Map;

import lombok.Data;

@Data
public class SummonerSpellData {
    private String version;
    private Map<String, SummonerSpellDto> data;
}
