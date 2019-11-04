package com.webflux.api.webflux.service;

import com.webflux.api.webflux.controller.request.PlanetRequest;
import com.webflux.api.webflux.model.Planet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetService {

    Mono<Planet> savePlanet(Planet planet);
    Flux<Planet> getAll();
    Mono<Planet> findById(String uuid);
    Mono<Void> delete(Planet planet);


}
