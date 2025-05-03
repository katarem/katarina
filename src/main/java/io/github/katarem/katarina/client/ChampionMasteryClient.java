package io.github.katarem.katarina.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.mastery.ChampionMasteryDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ChampionMasteryClient {

    private final RestTemplate restTemplate;
    private static final String URL_TEMPLATE = "https://%s.api.riotgames.com/lol/champion-mastery/%s";
    private final ConfigProperties configProperties;

    public ChampionMasteryDto[] getMasteries(String puuid) {
        String endpoint = String.format("v4/champion-masteries/by-puuid/%s?api_key=%s", puuid, configProperties.getApiKey());
        String url = String.format(URL_TEMPLATE, "euw1", endpoint);
        return restTemplate.getForObject(url, ChampionMasteryDto[].class);
    }

    /**
     * Get a champion mastery by puuid and champion ID.
     * @param puuid Player Universal Unique Identifier. Exact length of 78 characters. (Encrypted)
     */
    public ChampionMasteryDto getMastery(String puuid, long championId) {
        String endpoint = String.format("v4/champion-masteries/by-puuid/%s/by-champion/%d?api_key=%s", puuid, championId, configProperties.getApiKey());
        String url = String.format(URL_TEMPLATE, "euw1", endpoint);
        return restTemplate.getForObject(url, ChampionMasteryDto.class);
    }

    /**
     * Get specified number of top champion mastery entries sorted by number of champion points descending.
     * @param puuid Player Universal Unique Identifier. Exact length of 78 characters. (Encrypted)
     * @param count Number of entries to retrieve, defaults to 3.
     */
    public ChampionMasteryDto[] getMasteries(String puuid, Integer count) {
        String endpoint = String.format("v4/champion-masteries/by-puuid/%s/top?api_key=%s", puuid, configProperties.getApiKey());
        if (count != null) endpoint = endpoint.concat("&count=" + count);
        String url = String.format(URL_TEMPLATE, "euw1", endpoint);
        return restTemplate.getForObject(url, ChampionMasteryDto[].class);
    }

    /**
     * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
     * @param puuid Player Universal Unique Identifier. Exact length of 78 characters. (Encrypted)
     */
    public int getTotalMasteryScore(String puuid) {
        String endpoint = String.format("v4/scores/by-puuid/%s?api_key=%s", puuid, configProperties.getApiKey());
        String url = String.format(URL_TEMPLATE, "euw1", endpoint);
        return Optional.ofNullable(restTemplate.getForObject(url, Integer.class)).orElse(0);
    }

}
