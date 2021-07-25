package com.webflux.api.repository;

import com.webflux.api.model.Planet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface PlanetRepository extends ReactiveMongoRepository<Planet, String> {



}


