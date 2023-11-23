package com.todo.taska.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    public TaskEntity() {
    }

    public TaskEntity(String text) {
        this.text = text;
    }
}
