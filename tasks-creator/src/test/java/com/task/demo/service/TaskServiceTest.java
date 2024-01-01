package com.task.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

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

    @Test
    void shouldGetAllTasks() {
        var listOfTasks = List.of(
            new Task("task-id-1", "name-1", "description-1", false),
            new Task("task-id-2", "name-2", "description-2", false)
        );
        when(taskRepository.findAll()).thenReturn(listOfTasks);

        var returnedTasks = taskService.getTasks();

        assertEquals(2, returnedTasks.size());
        assertTrue(returnedTasks.containsAll(listOfTasks));
        
    }

    @Test
    void shouldGetASingleTaskById() {
        var taskId = "task-id-1";
        var task = new Task(taskId, "name-1", "description-1", false);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        var returnedTask = taskService.getTask(taskId);

        assertTrue(returnedTask.isPresent());
        assertEquals(taskId, returnedTask.get().getId());
        assertEquals(task.getDescription(), returnedTask.get().getDescription());
        assertEquals(task.getName(), returnedTask.get().getName());
        assertEquals(task.getDone(), returnedTask.get().getDone());
    }

    @Test
    void shouldGetNullObjectOnEmptyResult() {
        when(taskRepository.findById(anyString())).thenReturn(Optional.empty());

        var returnedTask = taskService.getTask("any-id");

        assertTrue(returnedTask.isEmpty());
    }

    @Test
    void shouldUpdateSingleTaskWithId() {
        var taskId = "task-id-1";
        var task = new Task(taskId, "name-1", "description-1", false);
        var updatedTask = new Task(taskId, "name-2", "description-2", true);
        when(taskRepository.save(task)).thenReturn(updatedTask);

        var returnedTask = taskService.updateSingleTask(task);

        assertEquals(taskId, returnedTask.getId());
        assertEquals("description-2", returnedTask.getDescription());
        assertEquals("name-2", returnedTask.getName());
        assertEquals(Boolean.TRUE, returnedTask.getDone());
    }
}