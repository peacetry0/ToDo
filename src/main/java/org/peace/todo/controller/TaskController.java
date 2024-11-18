package org.peace.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.peace.todo.dto.task.CreateTaskRequest;
import org.peace.todo.dto.task.TaskResponse;
import org.peace.todo.dto.task.UpdateTaskRequest;
import org.peace.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1.0/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;



    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable final  UUID id) {
        return taskService.getTaskById(id);
    }
    @PostMapping
    public TaskResponse createTask(@RequestBody @Valid final CreateTaskRequest createTaskRequest) {
        return taskService.createTask(createTaskRequest);
    }
    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable final UUID id, @RequestBody @Valid final UpdateTaskRequest updateTaskRequest) {
        return taskService.updateTask(id, updateTaskRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable final UUID id) {
        taskService.deleteTaskById(id);
    }
}