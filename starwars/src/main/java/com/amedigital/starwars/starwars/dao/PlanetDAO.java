package com.amedigital.starwars.starwars.dao;

import com.amedigital.starwars.starwars.model.Planet;
import com.amedigital.starwars.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetDAO {

    @Autowired
    PlanetRepository planetRepository;

    /*Salvar Planeta*/

    public Planet save(Planet plt){
        return planetRepository.save(plt);
    }

    /*Listar Planeta*/

    public List<Planet> findAll(){
        return planetRepository.findAll();
    }

    /*Get Planeta*/

    public Planet findOne(Long pltId){
        return planetRepository.getOne(pltId);
    }

    /*Deletar Planeta*/

    public void delete(Planet plt){

    }

}
