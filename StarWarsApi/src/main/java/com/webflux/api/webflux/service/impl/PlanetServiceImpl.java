package com.webflux.api.webflux.service.impl;
import com.webflux.api.webflux.model.Planet;
import com.webflux.api.webflux.model.repository.PlanetRepository;
import com.webflux.api.webflux.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetServiceImpl implements PlanetService {


    @Autowired
    PlanetRepository planetRepository;

    @Override
    public Mono<Planet> savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Flux<Planet> getAll() {
        return planetRepository.findAll();
    }

    @Override
    public Mono<Planet> findById(String uuid) {
        return planetRepository.findById(uuid);
    }

    @Override
    public Mono<Void> delete(Planet planet) {
        return planetRepository.delete(planet);
    }


}
