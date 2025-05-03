package io.github.katarem.katarina.model.summoner.spell;

import java.util.List;

import io.github.katarem.katarina.model.Image;
import lombok.Data;

@Data
public class SummonerSpellDto {
    private String id;
    private String name;
    private String description;
    private String tooltip;
    private Integer maxrank;
    private List<Integer> cooldown;
    private String cooldownBurn;
    private List<Integer> cost;
    private String costBurn;
    private List<Object> effect;
    private List<Object> effectBurn;
    private List<Object> vars;
    private String key;
    private Integer summonerLevel;
    private List<String> modes;
    private String costType;
    private String maxammo;
    private List<Integer> range;
    private String rangeBurn;
    private Image image;
    private String resource;
}
