package io.github.katarem.katarina.model.item;

import java.util.List;
import java.util.Map;

import io.github.katarem.katarina.model.Image;
import io.github.katarem.katarina.model.champion.Stats;
import lombok.Data;

@Data
public class ItemDto {
    public String name;
    public String description;
    public String colloq;
    public String plaintext;
    public List<String> into;
    public Image image;
    public Gold gold;
    public List<String> tags;
    public Map<String, Boolean> maps;
    public Stats stats;
}