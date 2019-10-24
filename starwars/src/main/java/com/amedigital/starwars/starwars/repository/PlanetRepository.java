package com.amedigital.starwars.starwars.repository;

import com.amedigital.starwars.starwars.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);

    Optional<Planet> findById(Long id);

    Optional<Planet> save(Long id);

    void delete(Planet id);


}
