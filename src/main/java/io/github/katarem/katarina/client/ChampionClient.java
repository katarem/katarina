package io.github.katarem.katarina.client;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.champion.ChampionData;
import io.github.katarem.katarina.model.champion.ChampionDto;
import io.github.katarem.katarina.model.champion.ChampionInfoDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ChampionClient {
    private final RestTemplate restTemplate;
    private final ConfigProperties configProperties;
    private static final String URL_ROTATION_TEMPLATE = "https://%s.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=%s";
    private static final String URL_CHAMPIONS_TEMPLATE = "https://ddragon.leagueoflegends.com/cdn/%s/data/%s/champion.json";

    /**
     * Returns champion rotations, including free-to-play and low-level free-to-play
     * rotations
     */
    public Optional<ChampionInfoDto> getRotationInfo(String region) {
        String url = String.format(URL_ROTATION_TEMPLATE,
                region, configProperties.getApiKey());
        return Optional.ofNullable(restTemplate.getForObject(url, ChampionInfoDto.class));
    }

    /**
     * Returns all League of Legends champions
     * 
     * @param version  Version of the game data to retrieve. For example, "12.10.1".
     * @param language Language of the game data to retrieve. For example, "en_US".
     * @return A map of champion names to ChampionDto objects. If invalid, it will retrieve an empty map
     */
    public Map<String, ChampionDto> getChampions(String version, String language) {
        String url = String.format(URL_CHAMPIONS_TEMPLATE, version,
                language);
        ChampionData championData = restTemplate.getForObject(url, ChampionData.class);
        if(championData == null) return Collections.emptyMap();
        return championData.getData();
    }

}