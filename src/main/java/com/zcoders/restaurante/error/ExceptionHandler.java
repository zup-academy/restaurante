package com.zcoders.restaurante.error;

import com.zcoders.restaurante.exception.RestauranteExistenteException;
import com.zcoders.restaurante.exception.RestauranteInexistenteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeralErrors(RuntimeException e, WebRequest request) {

        logger.error("Exception : " + e.getLocalizedMessage(), e);

        Map<String, Object> body = Map.of(
                "status", 500,
                "path", request.getDescription(false).replace("uri=", ""),
                "timestamp", LocalDateTime.now(),
                "message", e.getLocalizedMessage()
        );
        return ResponseEntity
                .internalServerError().body(body);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({RestauranteInexistenteException.class,
    RestauranteExistenteException.class})
    public ResponseEntity<?> handleError(RuntimeException e, WebRequest request) {

        logger.error("Exception : " + e.getLocalizedMessage(), e);

        Map<String, Object> body = Map.of(
                "status", 400,
                "path", request.getDescription(false).replace("uri=", ""),
                "timestamp", LocalDateTime.now(),
                "message", e.getLocalizedMessage()
        );
        return ResponseEntity
                .badRequest().body(body);
    }

}
