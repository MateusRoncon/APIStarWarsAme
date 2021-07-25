package com.webflux.api.controller;

import com.webflux.api.model.Planet;
import com.webflux.api.model.request.PlanetRequest;
import com.webflux.api.model.response.PlanetResponse;
import com.webflux.api.service.PlanetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping("/planets")
public class PlanetController {

    private static final Logger LOG = LogManager.getLogger();


    @Autowired
    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public Flux<PlanetResponse> getPlanets() {
        LOG.info("Iniciando processo de consulta dos planetas");
        return planetService.getAll();
    }

    @GetMapping("/{uuid}")
    public Mono<PlanetResponse> getPlanet(@PathVariable @Valid String uuid) {
        LOG.info("Iniciando processo de consulta do planeta com Uuid {}", uuid);
        return planetService.findById(uuid);
    }

    @PostMapping
    public Mono<PlanetResponse> savePlanet(@RequestBody @Valid PlanetRequest request) {
        LOG.info("Iniciando processo de cadastro de um novo planeta, request={}", request);
        return planetService.savePlanet(request);
    }

    @PutMapping("/{uuid}")
    public Mono<PlanetResponse> updatePlanet(@PathVariable(value = "uuid") String uuid, @RequestBody @Valid PlanetRequest request) {
        LOG.info("Atualizando o planeta={} com as informacoes da request={}", uuid, request);
        return planetService.updatePlanet(request, uuid);
    }

    @DeleteMapping("/{uuid}")
    public Mono<Void> deletePlanet(@PathVariable(value = "uuid") @Valid String uuid) {
        LOG.info("Removendo planeta com uuid={} da base", uuid);
        return planetService.delete(uuid);
    }


}
