package io.github.katarem.katarina.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.SummonerDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SummonerClient {

    private final RestTemplate restTemplate;
    private final ConfigProperties configProperties;
    private static final String URL_TEMPLATE = "https://%s.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s";

    /**
     * Get a summoner by PUUID.
     */
    public Optional<SummonerDto> getSummoner(String gameName, String tagLine, String region) {
        String url = String.format(URL_TEMPLATE,
                region, gameName, tagLine, configProperties.getApiKey());
        return Optional.ofNullable(restTemplate.getForObject(url, SummonerDto.class));
    }

}