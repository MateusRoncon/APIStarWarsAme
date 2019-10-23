package com.amedigital.starwars.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class PlanetRequest {


    private String name;

    private String weather;

    private String ground;

    private Integer qtAparitions;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public Integer getQtAparitions() {
        return qtAparitions;
    }

    public void setQtAparitions(Integer qtAparitions) {
        this.qtAparitions = qtAparitions;
    }
}