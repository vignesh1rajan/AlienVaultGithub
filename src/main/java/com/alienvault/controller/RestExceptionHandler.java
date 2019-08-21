package com.alienvault.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class.getName());

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity hadleBadRequest(HttpClientErrorException.BadRequest e) {
        log.error(e.getStatusText(), e);
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity hadleNotRequest(HttpClientErrorException.NotFound e) {
        log.error(e.getStatusText(), e);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity hadleForbidden(HttpClientErrorException.Forbidden e) {
        log.error(e.getStatusText(), e);
        return ResponseEntity.status(HttpStatus.FORBIDDEN
        ).build();
    }
}
