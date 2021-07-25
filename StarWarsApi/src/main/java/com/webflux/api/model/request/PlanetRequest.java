package com.webflux.api.model.request;

import com.webflux.api.model.Planet;

public class PlanetRequest {

    private String name;

    private String climate;

    private String terrain;

    private Integer films;

    public PlanetRequest() {
    }

    public PlanetRequest(String name, String climate, String terrain, Integer films) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.films = films;
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

    public Planet toModel(){
        Planet planet = new Planet();
        planet.setName(this.getName());
        planet.setFilms(this.getFilms());
        planet.setTerrain(this.getTerrain());
        planet.setClimate(this.getClimate());
        return planet;
    }
}
