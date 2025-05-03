package io.github.katarem.katarina.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.model.summoner.spell.SummonerSpellData;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SummonerSpellsClient {

    private final RestTemplate restTemplate;
    private static final String URL_TEMPLATE = "https://ddragon.leagueoflegends.com/cdn/%s/data/%s/summoner.json";
    
    public Optional<SummonerSpellData> getSummonerSpellData(String version, String language) {
        String url = String.format(URL_TEMPLATE, version, language);
        return Optional.ofNullable(restTemplate.getForObject(url, SummonerSpellData.class));
    }

}
