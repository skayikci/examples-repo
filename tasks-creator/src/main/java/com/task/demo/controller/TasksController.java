package com.task.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.model.Task;
import com.task.demo.service.TaskService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("/{id}")
    public Task getSingleTask(@PathVariable(required = true) String id) {
        var optionalTask = taskService.getTask(id);
        if(optionalTask.isPresent()) {
            return optionalTask.get();
        }
        else {
            log.warn("Task for given id couldn't be found.");
            return null;
        }
    }
    
    @PutMapping("/{id}")
    public Task updateSingleTask(@PathVariable String id, @RequestBody Task request) {
        if(request.getId().isBlank())
        {
            log.warn("Task id is mandatory.");
            return null;
        }
        if(!Objects.equals(id, request.getId()))
        {
            log.warn("Invalid task ids are provided. Please check your inputs");
            return null;
        }
        if(taskService.getTask(id).isEmpty()) {
            log.warn("Task for given id couldn't be found.");
            return null;
        }

        return taskService.updateSingleTask(request);
    }
    
    
}