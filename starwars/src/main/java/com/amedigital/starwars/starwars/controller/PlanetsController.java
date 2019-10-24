package com.amedigital.starwars.starwars.controller;

import com.amedigital.starwars.starwars.dao.PlanetDAO;

import com.amedigital.starwars.starwars.model.Planet;
import com.amedigital.starwars.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetsController {


    @Autowired
    PlanetDAO planetDAO;

    @Autowired
    private PlanetRepository planetRepository;


    @PostMapping("/")
    public Planet enviarPlaneta(@RequestBody @Valid Planet planet) {

        return planetDAO.save(planet);
    }


    @GetMapping("/")
    public List<Planet> getAllEmployees() {
        return planetDAO.findAll();
    }

    @GetMapping("/{id}")
    Optional<Planet> findById(@PathVariable(value="id") Long planetid)
        {
            return planetRepository.findById(planetid);
        }

    @GetMapping("/find/{name}")
    Optional<Planet> findByName(@PathVariable(value="name") String planetName)
    {
        return planetRepository.findByName(planetName);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable(value="id") Long planetId, @Valid @RequestBody Planet planetDetails){

        Optional<Planet> planetOptional = planetRepository.findById(planetId);

        if(!planetOptional.isPresent())
            return ResponseEntity.notFound().build();

        planetDetails.setId(planetId);

        planetRepository.save(planetDetails);

        return ResponseEntity.ok().build();

    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Planet> apagarPlaneta(@PathVariable(value="id") Long planetId){

        planetRepository.deleteById(planetId);

        return ResponseEntity.ok().build();
    }





}