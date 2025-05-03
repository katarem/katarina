package io.github.katarem.katarina.model.match;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Team {

    private List<Ban> bans;
    private Map<String, Feat> feats;
    private Map<String, Objective> objectives;
    private Integer teamId;
    private Boolean win;

}