package com.webflux.api.exception;

public class PlanetNotFoundException extends PlanetException {

    public PlanetNotFoundException() {
        super(404, "NOT_FOUND_ERROR", "Planet nao encontrado");
    }
}
