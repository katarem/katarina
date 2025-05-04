package io.github.katarem.katarina.service;

import io.github.katarem.katarina.client.ItemClient;
import io.github.katarem.katarina.client.MatchClient;
import io.github.katarem.katarina.client.SummonerSpellsClient;
import io.github.katarem.katarina.model.AccountDto;
import io.github.katarem.katarina.model.item.ItemData;
import io.github.katarem.katarina.model.match.MatchDto;
import io.github.katarem.katarina.model.summoner.spell.SummonerSpellData;
import io.github.katarem.katarina.utils.GameSearchQueryParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class GameService {

    private final MatchClient matchClient;
    private final ItemClient itemClient;
    private final SummonerSpellsClient summonerSpellsClient;

    public Optional<MatchDto> getGameById(String id, String region) {
        return matchClient.getGameById(id, region);
    }

    public List<String> getGamesByAccount(AccountDto accountDto, String region) {
        var games = matchClient.getGamesByAccount(accountDto, region);
        return Arrays.asList(games);
    }

    public List<String> getGamesByAccount(AccountDto accountDto,
                                          GameSearchQueryParams params) {
        var games = matchClient.getGamesByAccount(accountDto, params);
        return Arrays.asList(games);
    }

    public Optional<ItemData> getItems(String version, String lang) {
        return itemClient.getItems(version, lang);
    }

    public Optional<SummonerSpellData> getSummonerSpells(String version, String lang) {
        return summonerSpellsClient.getSummonerSpellData(version, lang);
    }


}
