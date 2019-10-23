package com.amedigital.starwars.starwars.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Planets")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)

public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("name")
    @NotNull(message = "{name.not.blank}")
    private String name;


    @NotNull(message = "{weather.not.blank}")
    private String weather;

    @NotBlank(message = "{ground.not.blank}")
    private String ground;


    private Integer qtAparitions;


    public Long getId() {
        return id;
    }


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
