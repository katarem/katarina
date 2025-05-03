package io.github.katarem.katarina.model.mastery;

import java.util.List;

import lombok.Data;
/**
 * This object contains single Champion Mastery information for player and champion combination.
 */
@Data
public class ChampionMasteryDto {
    private String puuid;
    private long championPointsUntilNextLevel;
    private boolean chestGranted;
    private long championId;
    private long lastPlayTime;
    private int championLevel;
    private int championPoints;
    private long championPointsSinceLastLevel;
    private int markRequiredForNextLevel;
    private int championSeasonMileStone;
    private int tokensEarned;
    private List<String> milestoneGrades;
}
