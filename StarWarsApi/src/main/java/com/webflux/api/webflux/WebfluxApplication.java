package com.webflux.api.webflux;

import com.webflux.api.webflux.model.Planet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}


	/*
	@Bean
	CommandLineRunner init(ReactiveMongoOperations operations, PlanetRepository planetRepository) {

		return args ->{
			Flux<Planet> productFlux = Flux.just(
					new Planet(null, "Alderaan", "temperate", "grasslands, mountains", 2),
					new Planet(null, "Yavin IV", "temperate, tropical", "jungle, rainforests", 1),
					new Planet(null, "Hoth", "frozen", "tundra, ice caves, mountain ranges", 1))
					.flatMap(planetRepository::save);

			productFlux
					.thenMany(planetRepository.findAll())
					.subscribe(System.out::println);
		};
	}
*/

}
