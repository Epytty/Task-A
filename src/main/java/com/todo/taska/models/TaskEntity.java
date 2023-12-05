package com.todo.taska.models;

import jakarta.persistence.*;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_entity_SEQ")
    @SequenceGenerator(name = "task_entity_SEQ", sequenceName = "task_entity_SEQ", allocationSize = 1)


    private Long id;
    private boolean completed;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TaskEntity() {
    }

    public TaskEntity(String text) {
        this.text = text;
    }

}