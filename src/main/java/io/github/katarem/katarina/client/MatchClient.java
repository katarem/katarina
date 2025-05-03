package io.github.katarem.katarina.client;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.AccountDto;
import io.github.katarem.katarina.model.match.MatchDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MatchClient {

    private final RestTemplate restTemplate;
    private final ConfigProperties configProperties;

    private static final String URL_TEMPLATE = "https://%s.api.riotgames.com/lol/match/v5/matches/";
    private static final String GET_MATCHES_BY_PLAYER_ID_TEMPLATE = "by-puuid/%s&api_key=%s";
    private static final String GET_MATCH_BY_MATCH_ID_TEMPLATE = "%s&api_key=%s";


    public String[] getGamesByAccount(AccountDto accountDto, String region){
        String url = String.format(URL_TEMPLATE.concat(GET_MATCHES_BY_PLAYER_ID_TEMPLATE),
                region, accountDto.getPuuid(), configProperties.getApiKey());
        String[] ids = restTemplate.getForObject(url, String[].class);
        if(ids == null || ids.length == 0)
            return new String[]{};
        return ids;
    }

    public Optional<MatchDto> getGameById(String gameId, String region){
        String url = String.format(URL_TEMPLATE.concat(GET_MATCH_BY_MATCH_ID_TEMPLATE),
                region, gameId, configProperties.getApiKey());
        MatchDto match = restTemplate.getForObject(url, MatchDto.class);
        return Optional.ofNullable(match);
    }
    
}
