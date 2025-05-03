package io.github.katarem.katarina.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.model.AccountDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AccountClient {

    private final RestTemplate restTemplate;

    /**
     * Get account by riot id
     */
    public Optional<AccountDto> getAccount(String gameName, String tagLine, String region, String apiKey) {
        String url = String.format("https://%s.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s",
                               region, gameName, tagLine, apiKey);
        return Optional.ofNullable(restTemplate.getForObject(url, AccountDto.class));
    }
}