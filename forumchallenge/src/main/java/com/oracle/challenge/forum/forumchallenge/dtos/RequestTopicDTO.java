package com.oracle.challenge.forum.forumchallenge.dtos;

import org.springframework.lang.NonNull;

public record RequestTopicDTO(
    @NonNull
    String title,
    @NonNull
    String course,
    @NonNull
    String message
) {
}
