package com.task.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.task.demo.model.Task;

public interface TaskRepository extends CrudRepository<Task, String>{
}
