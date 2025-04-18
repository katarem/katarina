package io.github.katarem.katarina.model.champion;

import lombok.Data;

@Data
public class Stats {
    public Integer hp;
    public Integer hpperlevel;
    public Integer mp;
    public Integer mpperlevel;
    public Integer movespeed;
    public Integer armor;
    public Double armorperlevel;
    public Integer spellblock;
    public Double spellblockperlevel;
    public Integer attackrange;
    public Integer hpregen;
    public Double hpregenperlevel;
    public Integer mpregen;
    public Integer mpregenperlevel;
    public Integer crit;
    public Integer critperlevel;
    public Integer attackdamage;
    public Integer attackdamageperlevel;
    public Double attackspeedperlevel;
    public Double attackspeed;
}
