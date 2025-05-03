package io.github.katarem.katarina.model.match.perks;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Style {

    private String description;
    private List<Map<String, Integer>> selections;
    private Integer style;

}
