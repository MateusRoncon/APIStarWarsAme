package com.webflux.api.controller;

import com.webflux.api.exception.PlanetException;
import com.webflux.api.model.StandardMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ExceptionHandlerController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(PlanetException.class)
    public Mono<ResponseEntity<StandardMessage>> handleAmeException(PlanetException e) {
        LOG.info("PlanetException {}", e.toString());
        return Mono.just(ResponseEntity.status(e.getHttpStatus())
                .body(new StandardMessage(e.getError(), e.getMessage())));
    }

}