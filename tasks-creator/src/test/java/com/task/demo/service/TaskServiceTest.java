package com.task.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.task.demo.controller.TaskRequest;
import com.task.demo.model.Task;
import com.task.demo.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldCreateTaskFromRequestBody() {
        var requestedTask = new Task("task-id", "name", "description", Boolean.FALSE);   
        var inputTask = new TaskRequest("name", "description", Boolean.FALSE);   
        var maybeTask = new Task();    
        maybeTask.setDescription("description");
        maybeTask.setName("name");
        maybeTask.setDone(Boolean.FALSE);
        maybeTask.setId("task-id");
    
        when(taskRepository.save(any())).thenReturn(maybeTask);

        var createdTask = taskService.createService(inputTask);

        assertEquals(createdTask.getDescription(), requestedTask.getDescription());
        assertEquals(createdTask.getName(), requestedTask.getName());
 
    }
}