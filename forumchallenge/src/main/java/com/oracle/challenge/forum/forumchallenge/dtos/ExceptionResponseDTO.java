package com.oracle.challenge.forum.forumchallenge.dtos;

import java.time.LocalDateTime;

public record ExceptionResponseDTO(
    LocalDateTime timestamp,
    Integer status,
    String message,
    String path
) {
    
}
