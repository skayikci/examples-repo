package com.task.demo.service;

import org.springframework.stereotype.Service;

import com.task.demo.controller.TaskRequest;
import com.task.demo.model.Task;
import com.task.demo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createService(TaskRequest task) {
        var taskEntity = new Task();
        taskEntity.setDescription(task.getDescription());
        taskEntity.setName(task.getName());
        taskEntity.setDone(task.getDone());
        var createdEntity = taskRepository.save(taskEntity);
        return createdEntity;
    }

}
