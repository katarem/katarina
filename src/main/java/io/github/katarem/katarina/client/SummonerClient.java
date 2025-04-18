package io.github.katarem.katarina.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.SummonerDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SummonerClient {

    private final RestTemplate restTemplate;
    private final ConfigProperties configProperties;

    /**
     * Get a summoner by PUUID.
     */
    public SummonerDto getSummoner(String gameName, String tagLine, String region) {
        String url = String.format("https://%s.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s",
                region, gameName, tagLine, configProperties.getApiKey());
        return restTemplate.getForObject(url, SummonerDto.class);
    }

}