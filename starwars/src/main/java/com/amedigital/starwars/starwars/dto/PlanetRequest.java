package com.amedigital.starwars.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class PlanetRequest {

    @JsonProperty("name")
    @NotNull(message = "{name.not.blank}")
    private String name;

    @NotNull(message = "{weather.not.blank}")
    private String weather;

    @NotNull(message = "{distance.not.blank}")
    @Min(value =  200 , message = "{distance.not.valid}")
    private Integer distance;

    private String ground;
    private Integer qtAparitions;

    public String getName() {

        return name;
    }
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
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