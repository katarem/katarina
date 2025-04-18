package io.github.katarem.katarina.model;

import lombok.Data;

@Data
public class SummonerDto {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String id;
    private String puuid;
    private long summonerLevel;
}
