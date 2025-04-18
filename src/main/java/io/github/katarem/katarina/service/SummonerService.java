package io.github.katarem.katarina.service;

import org.springframework.stereotype.Service;

import io.github.katarem.katarina.client.AccountClient;
import io.github.katarem.katarina.client.SummonerClient;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SummonerService {

    private final AccountClient riotApiClient;
    private final SummonerClient summonerClient;

    public String getSummoner(String gameName, String tagLine, String region, String apiKey) {
        return riotApiClient.getAccount(gameName, tagLine, region, apiKey).getPuuid();
    }

    
}