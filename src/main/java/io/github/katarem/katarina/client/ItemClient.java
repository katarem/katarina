package io.github.katarem.katarina.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.model.item.ItemData;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ItemClient {

    private final RestTemplate restTemplate;
    private static final String URL_TEMPLATE = "https://ddragon.leagueoflegends.com/cdn/%s/data/%s/item.json";

    public Optional<ItemData> getItems(String version, String language) {
        String url = String.format(URL_TEMPLATE, version, language);
        return Optional.ofNullable(restTemplate.getForObject(url, ItemData.class));
    }
}
