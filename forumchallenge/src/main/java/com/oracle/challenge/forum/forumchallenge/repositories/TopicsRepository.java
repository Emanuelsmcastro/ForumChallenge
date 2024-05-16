package com.oracle.challenge.forum.forumchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.challenge.forum.forumchallenge.models.Topic;

public interface TopicsRepository extends JpaRepository<Topic, Long>{
    
}
