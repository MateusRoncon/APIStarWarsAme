package com.webflux.api.configuration;

import com.webflux.api.model.StandardMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.*;

@Component
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String CONTENT_TYPE = "Content-Type";

    @Autowired
    private DataBufferWriter bufferWriter;

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        LOG.info("An exception was thrown by the webfilter [{}]", ex.getMessage());
        HttpStatus status = INTERNAL_SERVER_ERROR;
        StandardMessage standardMessage = new StandardMessage("UnknownError", "An unkown error has occured.");
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        }
        LOG.info("Writing response [{}] for exception.", standardMessage);
        exchange.getResponse().getHeaders().add(CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        exchange.getResponse().setStatusCode(status);
        return bufferWriter.write(exchange.getResponse(), standardMessage);
    }
}