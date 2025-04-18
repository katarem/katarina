package io.github.katarem.katarina.model;

import lombok.Data;

@Data
public class ChampionInfoDto {
    private int maxNewPlayerLevel;
    private int[] freeChampionIdsForNewPlayers;
    private int[] freeChampionIds;
}