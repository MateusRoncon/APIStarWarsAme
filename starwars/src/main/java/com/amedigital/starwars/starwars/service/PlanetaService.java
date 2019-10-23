package com.amedigital.starwars.starwars.service;

import com.amedigital.starwars.starwars.model.Planet;
import com.amedigital.starwars.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanetaService {

    @Autowired
    private PlanetRepository planetRepository;

    private void inserir(){
        Optional<Planet> planet = this.planetRepository.findByName("EASEASEsa");

        Optional.of("");
    }
}
