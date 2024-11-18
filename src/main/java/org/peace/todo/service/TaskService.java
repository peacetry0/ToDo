package org.peace.todo.service;

import lombok.RequiredArgsConstructor;
import org.peace.todo.convertor.TaskConvertor;
import org.peace.todo.dto.task.CreateTaskRequest;
import org.peace.todo.dto.task.TaskResponse;
import org.peace.todo.dto.task.UpdateTaskRequest;
import org.peace.todo.dto.user.UpdateUserRequest;
import org.peace.todo.dto.user.UserResponse;
import org.peace.todo.model.Task;
import org.peace.todo.model.User;
import org.peace.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

 private final TaskRepository taskRepository;
 private final TaskConvertor    taskConvertor;


    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskConvertor::toResponse)
                .toList();
    }
    public TaskResponse getTaskById(final UUID id) {

        final Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return taskConvertor.toResponse(task);
    }
    public TaskResponse createTask(final CreateTaskRequest createTaskRequest) {

       final Task task = taskConvertor.toEntity(createTaskRequest);

        return taskConvertor.toResponse(taskRepository.save(task));
    }
    public TaskResponse updateTask(final UUID id, final UpdateTaskRequest updateTaskRequest) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask = taskConvertor.toUpdateTask(existingTask,updateTaskRequest);

        return taskConvertor.toResponse(taskRepository.save(existingTask));


    }

    public void deleteTaskById(UUID id) {

        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}
