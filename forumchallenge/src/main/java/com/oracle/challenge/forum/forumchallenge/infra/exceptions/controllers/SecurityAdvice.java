package com.oracle.challenge.forum.forumchallenge.infra.exceptions.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.oracle.challenge.forum.forumchallenge.dtos.ExceptionResponseDTO;

@ControllerAdvice
public class SecurityAdvice {
    
    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<ExceptionResponseDTO> jwtCreationExceptionHandler(JWTCreationException ex, WebRequest request){
        ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ExceptionResponseDTO> jwtVerificationExceptionHandler(JWTVerificationException ex, WebRequest request){
        ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
    }
}
