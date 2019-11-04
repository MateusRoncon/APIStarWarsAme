package com.webflux.api.webflux.model.repository;

import com.webflux.api.webflux.model.Planet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface PlanetRepository extends ReactiveMongoRepository<Planet, String> {



}


