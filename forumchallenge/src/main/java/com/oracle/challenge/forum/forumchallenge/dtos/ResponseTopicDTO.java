package com.oracle.challenge.forum.forumchallenge.dtos;

import java.time.LocalDateTime;

public record ResponseTopicDTO(
    Long id,
    String title,
    String message,
    LocalDateTime creationDateTime
) {
}
