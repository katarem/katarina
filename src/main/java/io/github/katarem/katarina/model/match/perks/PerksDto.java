package io.github.katarem.katarina.model.match.perks;

import lombok.Data;

import java.util.List;

@Data
public class PerksDto {
    private StatPerks statPerks;
    private List<Style> styles;
}