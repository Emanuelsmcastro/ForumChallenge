package com.oracle.challenge.forum.forumchallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.challenge.forum.forumchallenge.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
}
