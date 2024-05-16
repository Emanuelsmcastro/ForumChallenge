package com.oracle.challenge.forum.forumchallenge.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oracle.challenge.forum.forumchallenge.dtos.RequestTopicDTO;
import com.oracle.challenge.forum.forumchallenge.dtos.ResponseTopicDTO;
import com.oracle.challenge.forum.forumchallenge.services.TopicServices;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicServices services;

    @GetMapping("/")
    public ResponseEntity<Page<ResponseTopicDTO>> getTopicList(Pageable pageable) {
        return ResponseEntity.ok().body(services.getTopicList(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok().body(services.getTopic(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        services.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<ResponseTopicDTO> saveTopic(@RequestBody RequestTopicDTO requestTopicDTO) {
        ResponseTopicDTO responseTopicDTO = services.saveTopic(requestTopicDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseTopicDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(responseTopicDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTopicDTO> updateTopic(@PathVariable Long id,
            @RequestBody RequestTopicDTO requestTopicDTO) {
        return ResponseEntity.ok().body(services.updateTopic(id, requestTopicDTO));
    }
}
