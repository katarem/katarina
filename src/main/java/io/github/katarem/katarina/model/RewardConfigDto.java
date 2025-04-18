package io.github.katarem.katarina.model;

import lombok.Data;

@Data
public class RewardConfigDto {
    private String rewardValue;
    private String rewardType;
    private int maximumReward;
}
