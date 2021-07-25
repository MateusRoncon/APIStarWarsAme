package com.webflux.api.model;

import com.webflux.api.model.request.PlanetRequest;
import com.webflux.api.model.response.PlanetResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Document
public class Planet {


    @Id
    @NotEmpty
    private String uuid;

    @NotEmpty
    private String name;

    @NotEmpty
    private String climate;

    @NotEmpty
    private String terrain;


    private Integer films;


    public Planet() {
    }

    public Planet(String name, String climate, String terrain, Integer films) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.films = films;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Integer getFilms() {
        return films;
    }

    public void setFilms(Integer films) {
        this.films = films;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(uuid, planet.uuid) &&
                Objects.equals(name, planet.name) &&
                Objects.equals(climate, planet.climate) &&
                Objects.equals(terrain, planet.terrain) &&
                Objects.equals(films, planet.films);
    }


    @Override
    public int hashCode(){
        return Objects.hash(uuid, name, climate, terrain, films);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planet{");
        sb.append("uuid='").append(uuid).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", climate='").append(climate).append('\'');
        sb.append(", terrain='").append(terrain).append('\'');
        sb.append(", films=").append(films);
        sb.append('}');
        return sb.toString();
    }

    public Planet updateData(PlanetRequest planet) {
        this.name = Optional.ofNullable(planet.getName()).orElse(name);
        this.climate = Optional.ofNullable(planet.getClimate()).orElse(climate);
        this.terrain = Optional.ofNullable(planet.getTerrain()).orElse(terrain);
        this.films = Optional.ofNullable(planet.getFilms()).orElse(films);
        return this;
    }

    public static PlanetResponse toResponse(Planet planet){
        PlanetResponse response = new PlanetResponse();
        response.setUuid(planet.getUuid());
        response.setName(planet.getName());
        response.setClimate(planet.getClimate());
        response.setTerrain(planet.getTerrain());
        response.setFilms(planet.getFilms());
        return response;
    }
}
