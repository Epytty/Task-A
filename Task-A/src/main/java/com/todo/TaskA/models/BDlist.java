package com.todo.TaskA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BDlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tasktext;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTasktext() {
        return tasktext;
    }

    public void setTasktext(String tasktext) {
        this.tasktext = tasktext;
    }

    public BDlist() {
    }

    public BDlist(String text) {
        this.tasktext = text;
    }
}
