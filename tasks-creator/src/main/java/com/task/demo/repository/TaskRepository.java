package com.task.demo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.task.demo.model.Task;

public interface TaskRepository extends ListCrudRepository<Task, String>{
}
