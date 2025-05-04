package io.github.katarem.katarina.client;

import io.github.katarem.katarina.config.ConfigProperties;
import io.github.katarem.katarina.model.AccountDto;
import io.github.katarem.katarina.model.match.MatchDto;
import io.github.katarem.katarina.utils.GameSearchQueryParams;
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


    public String[] getGamesByAccount(AccountDto accountDto, GameSearchQueryParams params) {

        if (params.getRegion() == null) return new String[]{};

        String url = String.format(URL_TEMPLATE.concat(GET_MATCHES_BY_PLAYER_ID_TEMPLATE),
                params.getRegion(), accountDto.getPuuid(), configProperties.getApiKey());

        url = appendGameSearchParams(url, params);

        String[] ids = restTemplate.getForObject(url, String[].class);
        if (ids == null || ids.length == 0)
            return new String[]{};
        return ids;
    }

    public String[] getGamesByAccount(AccountDto accountDto, String region) {
        var params = GameSearchQueryParams.builder()
                .region(region)
                .build();
        return getGamesByAccount(accountDto, params);
    }

    public Optional<MatchDto> getGameById(String gameId, String region) {
        String url = String.format(URL_TEMPLATE.concat(GET_MATCH_BY_MATCH_ID_TEMPLATE),
                region, gameId, configProperties.getApiKey());
        MatchDto match = restTemplate.getForObject(url, MatchDto.class);
        return Optional.ofNullable(match);
    }

    private String appendGameSearchParams(String url, GameSearchQueryParams params) {
        StringBuilder urlBuilder = new StringBuilder(url);

        if (params.getQueue() != null)
            urlBuilder.append(String.format("&count=%d", params.getCount()));
        if (!params.getType().isEmpty())
            urlBuilder.append(String.format("&type=%s", params.getType()));
        if (params.getStart() != null)
            urlBuilder.append(String.format("&start=%d", params.getStart()));
        if (params.getStartTime() != null)
            urlBuilder.append(String.format("&start_time=%d", params.getStartTime()));
        if (params.getEndTime() != null)
            urlBuilder.append(String.format("&end_time=%d", params.getEndTime()));

        return urlBuilder.toString();
    }

}
