package com.amedigital.starwars.starwars.dto;

import java.util.UUID;

public class PlanetResponse {


    private String uuid;
    private String name;

    public String getUuid() {
        return uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetResponse() {
        this.uuid = UUID.randomUUID().toString();
    }
}