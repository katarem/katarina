package io.github.katarem.katarina.model;

import lombok.Data;

@Data
public class NextSeasonMilestonesDto {
    private int rewardMarks;
    private boolean bonus;
    private RewardConfigDto rewardConfig;
}
