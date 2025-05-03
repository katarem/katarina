package io.github.katarem.katarina.model.champion;

import lombok.Data;

@Data
public class ChampionInfoDto {
    private int maxNewPlayerLevel;
    private int[] freeChampionIdsForNewPlayers;
    private int[] freeChampionIds;
}