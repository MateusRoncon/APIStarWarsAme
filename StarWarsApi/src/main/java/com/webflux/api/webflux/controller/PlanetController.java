package com.webflux.api.webflux.controller;
import com.webflux.api.webflux.controller.request.PlanetRequest;
import com.webflux.api.webflux.controller.request.PlanetResponse;
import com.webflux.api.webflux.model.Planet;
import com.webflux.api.webflux.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;


@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;


    public PlanetController(PlanetService planetService){
        this.planetService = planetService;
    }


    @GetMapping
    public Flux<Planet> getPlanets(){
        return planetService.getAll();
    }

    @GetMapping("/{uuid}")
    public Mono<ResponseEntity<Planet>> getPlanet(@PathVariable @Valid String uuid){
        return planetService.findById(uuid)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Planet> savePlanet(@RequestBody @Valid Planet planet){
        return planetService.savePlanet(planet);
    }

    @PutMapping("/{uuid}")
    public Mono<ResponseEntity<PlanetResponse>> updatePlanet(@PathVariable(value = "uuid") String uuid, @RequestBody @Valid PlanetRequest planet){
        return planetService.findById(uuid)
                .flatMap(planet1 -> this.planetService.savePlanet(planet.toModel()))
                .map(PlanetResponse::new)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{uuid}")
    public Mono<ResponseEntity<Void>> deletePlanet(@PathVariable(value = "uuid") @Valid String uuid){

        return planetService.findById(uuid)
                .flatMap(existingPlanet ->
                        planetService.delete(existingPlanet)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty( ResponseEntity.notFound().build());


    }


}
