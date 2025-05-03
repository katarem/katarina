package io.github.katarem.katarina.model.match;

import lombok.Data;

import java.util.List;

@Data
public class Metadata {

    private String dataVersion;
    private String matchId;
    private List<String> participants;

}