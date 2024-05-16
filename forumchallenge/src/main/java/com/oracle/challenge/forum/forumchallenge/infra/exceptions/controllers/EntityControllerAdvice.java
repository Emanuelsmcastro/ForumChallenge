package com.oracle.challenge.forum.forumchallenge.infra.exceptions.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.oracle.challenge.forum.forumchallenge.dtos.ExceptionResponseDTO;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class EntityControllerAdvice {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> entityNotFoundExceptionHandler(EntityNotFoundException ex, WebRequest request){
        ExceptionResponseDTO responnse = new ExceptionResponseDTO(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(responnse);
    }

}
