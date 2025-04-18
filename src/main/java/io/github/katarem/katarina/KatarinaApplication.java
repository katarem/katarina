package io.github.katarem.katarina;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.github.katarem.katarina.client.AccountClient;
import io.github.katarem.katarina.config.ConfigProperties;

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

	@Bean
	CommandLineRunner runner(AccountClient client, ConfigProperties configProperties){
		return args -> {
			var response = client.getAccount("γeγ", "KING", "europe", configProperties.getApiKey());
			System.out.println(response.getPuuid());
		};
	}

}
