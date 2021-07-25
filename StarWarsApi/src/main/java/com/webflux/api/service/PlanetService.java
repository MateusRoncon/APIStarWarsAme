package com.webflux.api.service;

import com.webflux.api.model.Planet;
import com.webflux.api.model.request.PlanetRequest;
import com.webflux.api.model.response.PlanetResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetService {

    Mono<PlanetResponse> savePlanet(PlanetRequest planet);

    Flux<PlanetResponse> getAll();

    Mono<PlanetResponse> findById(String uuid);

    Mono<Void> delete(String uuid);

    Mono<PlanetResponse> updatePlanet(PlanetRequest planet, String uuid);


}
