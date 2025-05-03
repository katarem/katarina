package io.github.katarem.katarina.service;

import io.github.katarem.katarina.client.ChampionClient;
import io.github.katarem.katarina.client.ChampionMasteryClient;
import io.github.katarem.katarina.model.AccountDto;
import io.github.katarem.katarina.model.champion.ChampionDto;
import io.github.katarem.katarina.model.champion.ChampionInfoDto;
import io.github.katarem.katarina.model.mastery.ChampionMasteryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChampionService {

    private final ChampionClient championClient;
    private final ChampionMasteryClient championMasteryClient;

    public List<ChampionMasteryDto> getMasteries(AccountDto accountDto) {
        return Arrays.asList(championMasteryClient.getMasteries(accountDto.getPuuid()));
    }

    public List<ChampionMasteryDto> getMasteries(AccountDto accountDto, Integer count) {
        return Arrays.asList(championMasteryClient.getMasteries(accountDto.getPuuid(), count));
    }

    public Optional<ChampionMasteryDto> getMastery(AccountDto accountDto, long id) {
        return championMasteryClient.getMastery(accountDto.getPuuid(), id);
    }

    public Optional<ChampionMasteryDto> getMastery(AccountDto accountDto,
                                                   String version,
                                                   String language,
                                                   String championName) {

        var masteries = getMasteries(accountDto);
        var champion = getChampion(championName, version, language);
        return champion.flatMap(championDto ->
                masteries.stream()
                        .filter(mastery -> mastery.getChampionId() == Long.parseLong(championDto.getKey()))
                        .findFirst());

    }

    public Map<String, ChampionDto> getAllChampions(String version, String language) {
        return championClient.getChampions(version, language);
    }

    public Optional<ChampionDto> getChampion(String id, String version, String language) {
        var champs = championClient.getChampions(version, language);
        return Optional.ofNullable(champs.get(id));
    }

    public Optional<ChampionInfoDto> getChampionsRotation(String region) {
        return championClient.getRotationInfo(region);
    }

    public Integer getTotalMasteryScore(AccountDto accountDto) {
        return championMasteryClient.getTotalMasteryScore(accountDto.getPuuid());
    }

}
