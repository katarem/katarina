package io.github.katarem.katarina.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.ChampionInfoDto;
import io.github.katarem.katarina.model.champion.ChampionData;
import io.github.katarem.katarina.model.champion.ChampionDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ChampionClient {
    private final RestTemplate restTemplate;
    private final ConfigProperties configProperties;

    /**
     * Returns champion rotations, including free-to-play and low-level free-to-play rotations
     */
    public ChampionInfoDto getRotationInfo(String region) {
        String url = String.format("https://%s.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=%s",
                region, configProperties.getApiKey());
        return restTemplate.getForObject(url, ChampionInfoDto.class);
    }
    /**
     * Returns all League of Legends champions
     * @param version Version of the game data to retrieve. For example, "12.10.1".
     * @param language Language of the game data to retrieve. For example, "en_US".
     * @return A map of champion names to ChampionDto objects.
     */
    public Map<String, ChampionDto> getChampions(String version, String language){
        String url = String.format("https://ddragon.leagueoflegends.com/cdn/%s/data/%s/champion.json", version, language);
        ChampionData championData = restTemplate.getForObject(url, ChampionData.class);
        return championData.getData();
    }

}