package com.webflux.api;


import com.webflux.api.model.request.PlanetRequest;
import com.webflux.api.model.response.PlanetResponse;
import com.webflux.api.service.PlanetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlanetServiceTest {

    PlanetService service;
    PlanetRequest requestOK = new PlanetRequest("Alderaan", "temperate", "grasslands, mountains", 2);

    @Test
    void shouldCreateAPlanet() {
        PlanetResponse planet = service.savePlanet(requestOK).block();

        Assertions.assertNotNull(planet);
        Assertions.assertEquals(service.findById(planet.getUuid()).block(), planet);

    }

}
