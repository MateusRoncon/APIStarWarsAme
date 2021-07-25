package com.webflux.api.service.impl;

import com.webflux.api.exception.PlanetNotFoundException;
import com.webflux.api.model.Planet;
import com.webflux.api.model.request.PlanetRequest;
import com.webflux.api.model.response.PlanetResponse;
import com.webflux.api.repository.PlanetRepository;
import com.webflux.api.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetServiceImpl implements PlanetService {


    @Autowired
    PlanetRepository planetRepository;

    @Override
    public Mono<PlanetResponse> savePlanet(PlanetRequest planet) {
        return planetRepository.save(planet.toModel())
                .map(PlanetResponse::new);
    }

    @Override
    public Flux<PlanetResponse> getAll() {
        return planetRepository.findAll()
                .map(Planet::toResponse);
    }

    @Override
    public Mono<PlanetResponse> findById(String uuid) {
        return planetRepository.findById(uuid)
                .map(Planet::toResponse)
                .switchIfEmpty(Mono.error(new PlanetNotFoundException()));
    }

    @Override
    public Mono<Void> delete(String uuid) {
        return planetRepository.findById(uuid)
                .flatMap(planet -> planetRepository.delete(planet))
                .switchIfEmpty(Mono.error(new PlanetNotFoundException()));
    }

    @Override
    public Mono<PlanetResponse> updatePlanet(PlanetRequest planet, String uuid) {
        return planetRepository.findById(uuid)
                .flatMap(existingPlanet -> planetRepository.save(existingPlanet.updateData(planet)))
                .map(Planet::toResponse)
                .switchIfEmpty(Mono.error(new PlanetNotFoundException()));
    }

}
