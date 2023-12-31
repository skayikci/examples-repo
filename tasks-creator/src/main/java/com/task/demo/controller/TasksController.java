package com.task.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.model.Task;
import com.task.demo.service.TaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TasksController {
    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskRequest task) {
        Task createdTask = taskService.createService(task);
        return createdTask;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
    
    
}