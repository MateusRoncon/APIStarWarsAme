package com.amedigital.starwars.starwars.controller;

import com.amedigital.starwars.starwars.dao.PlanetDAO;

import com.amedigital.starwars.starwars.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetsController {


    @Autowired
    PlanetDAO planetDAO;


    @PostMapping("/")
    public Planet enviarPlaneta(@RequestBody @Valid Planet planet) {

        return planetDAO.save(planet);
    }


    @GetMapping("/")
    public List<Planet> getAllEmployees() {
        return planetDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable(value="id") Long planetId){

        Planet planet = planetDAO.findOne(planetId);

        if(planet == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(planet);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable(value="id") Long planetId, @Valid @RequestBody Planet planetDetails){

        Planet planet = planetDAO.findOne(planetId);

        if(planet == null){
            return ResponseEntity.notFound().build();
        }
        planet.setName(planetDetails.getName());
        planet.setGround(planetDetails.getGround());
        planet.setWeather(planetDetails.getWeather());
        planet.setQtAparitions(planetDetails.getQtAparitions());

        Planet updatePlanet = planetDAO.save(planet);

        return ResponseEntity.ok().body(updatePlanet);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Planet> apagarPlaneta(@PathVariable(value="id") Long planetId){

        Planet planet = planetDAO.findOne(planetId);

        if(planet == null){
            return ResponseEntity.notFound().build();
        }
        planetDAO.delete(planet);

        return ResponseEntity.ok().build();
    }





}