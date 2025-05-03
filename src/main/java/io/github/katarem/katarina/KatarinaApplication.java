package io.github.katarem.katarina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class KatarinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KatarinaApplication.class, args);

    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
