package io.github.katarem.katarina.model.champion;

import java.util.List;

import lombok.Data;

@Data
public class ChampionDto {
    public String version;
    public String id;
    public String key;
    public String name;
    public String title;
    public String blurb;
    public Info info;
    public Image image;
    public List<String> tags;
    public String partype;
    public Stats stats;
}
