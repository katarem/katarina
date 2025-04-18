package io.github.katarem.katarina.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class ConfigProperties {

    @Value("${katarina.api.key}")
    private String apiKey;


}
