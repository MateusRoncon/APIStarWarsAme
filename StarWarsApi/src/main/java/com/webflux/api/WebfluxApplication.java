package com.webflux.api;

import com.webflux.api.model.Planet;
import com.webflux.api.repository.PlanetRepository;
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
//
//	@Bean
//	CommandLineRunner init(ReactiveMongoOperations operations, PlanetRepository planetRepository) {
//
//		return args ->{
//			Flux<Planet> productFlux = Flux.just(
//					new Planet("Alderaan", "temperate", "grasslands, mountains", 2),
//					new Planet("Yavin IV", "temperate, tropical", "jungle, rainforests", 1),
//					new Planet("Hoth", "frozen", "tundra, ice caves, mountain ranges", 1))
//					.flatMap(planetRepository::save);
//
//			productFlux
//					.thenMany(planetRepository.findAll())
//					.subscribe(System.out::println);
//		};
//	}


}
