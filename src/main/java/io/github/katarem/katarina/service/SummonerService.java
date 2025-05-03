package io.github.katarem.katarina.service;

import io.github.katarem.katarina.config.ConfigProperties;
import org.springframework.stereotype.Service;

import io.github.katarem.katarina.client.AccountClient;
import io.github.katarem.katarina.client.SummonerClient;
import io.github.katarem.katarina.model.AccountDto;
import io.github.katarem.katarina.model.SummonerDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SummonerService {

    private final ConfigProperties configProperties;
    private final AccountClient riotApiClient;
    private final SummonerClient summonerClient;

    public Optional<AccountDto> getAccount(String gameName, String tagLine, String region, String apiKey) {
        return riotApiClient.getAccount(gameName, tagLine, region, configProperties.getApiKey());
    }

    public Optional<SummonerDto> getSummoner(String gameName, String tagLine, String region) {
        return summonerClient.getSummoner(gameName, tagLine, region);
    }

    
}