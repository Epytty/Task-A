package com.todo.taska.repositories;

import com.todo.taska.models.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}