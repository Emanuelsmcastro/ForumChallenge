package com.oracle.challenge.forum.forumchallenge.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_topics")
public class Topic implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime creationDateTime;

    public Topic() {
    }

    public Topic(String title, String course, String message) {
        this.title = title;
        this.course = course;
        this.message = message;
    }

    public Topic(Long id, String title, String course, String message) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCourse() {
        return course;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Topics [id=" + id + ", title=" + title + ", course=" + course + ", message=" + message + "]";
    }
}
