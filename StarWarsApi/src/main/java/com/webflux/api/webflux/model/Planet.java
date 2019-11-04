package com.webflux.api.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;


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

    public Planet(String uuid, String name, String climate, String terrain, Integer films) {
        this.uuid = uuid;
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

        return "Planet{"+
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", terrain='" + terrain + '\'' +
                ", films='" + films +
                '}';

    }


}
