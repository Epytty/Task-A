package com.todo.taska.repositories;

import com.todo.taska.models.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findByCompleted(boolean completed);
}