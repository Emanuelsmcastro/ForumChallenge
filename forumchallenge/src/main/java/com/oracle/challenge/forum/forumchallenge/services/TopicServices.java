package com.oracle.challenge.forum.forumchallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oracle.challenge.forum.forumchallenge.dtos.RequestTopicDTO;
import com.oracle.challenge.forum.forumchallenge.dtos.ResponseTopicDTO;
import com.oracle.challenge.forum.forumchallenge.mappers.TopicMapper;
import com.oracle.challenge.forum.forumchallenge.models.Topic;
import com.oracle.challenge.forum.forumchallenge.repositories.TopicsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TopicServices {
    
    @Autowired
    private TopicsRepository repository;

    public ResponseTopicDTO saveTopic(RequestTopicDTO requestTopicDTO){
        Topic topic = repository.save(TopicMapper.fromDTO(requestTopicDTO));
        return TopicMapper.toDTO(topic);
    }

    public void deleteTopic(Long id){
        Topic topic = getTopicModel(id);
        repository.delete(topic);
    }

    public ResponseTopicDTO updateTopic(Long id, RequestTopicDTO requestTopicDTO){
        Topic topic = getTopicModel(id);
        topic.setTitle(requestTopicDTO.title());
        topic.setCourse(requestTopicDTO.course());
        topic.setMessage(requestTopicDTO.message());
        return TopicMapper.toDTO(repository.save(topic));
    }

    public ResponseTopicDTO getTopic(Long id){
        Topic topic = getTopicModel(id);
        return TopicMapper.toDTO(topic);
    }

    public Page<ResponseTopicDTO> getTopicList(Pageable pageable){
        return TopicMapper.toDTO(repository.findAll(pageable));
    }

    private Topic getTopicModel(Long id){
        Optional<Topic> topic = repository.findById(id);
        if(!topic.isPresent()) throw new EntityNotFoundException("Unable to find Topic with id " + id);
        return topic.get();
    }
}
