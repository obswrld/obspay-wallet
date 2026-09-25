package com.obspay.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateTitle(DuplicateException ex) {
        Map<String, Object> error = Map.of(
                "success", false,
                "error", Map.of(
                        "code", "DUPLICATE_EMAIL",
                        "message", ex.getMessage()
                )
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> error = Map.of(
                "success", false,
                "error", Map.of(
                        "code", "VALIDATION_ERROR",
                        "message", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
