package org.peace.todo.convertor;

import org.peace.todo.dto.task.CreateTaskRequest;
import org.peace.todo.dto.task.TaskResponse;
import org.peace.todo.dto.task.UpdateTaskRequest;
import org.peace.todo.dto.user.CreateUserRequest;
import org.peace.todo.dto.user.UpdateUserRequest;
import org.peace.todo.dto.user.UserResponse;
import org.peace.todo.model.Task;
import org.peace.todo.model.User;
import org.springframework.stereotype.Component;

@Component
public class TaskConvertor {

    public Task toEntity(final CreateTaskRequest createTaskRequest) {

        Task task = new Task();
        task.setTitle(createTaskRequest.title());
        task.setDescription(createTaskRequest.description());
        return task;
    }
    public Task toUpdateTask(final Task existTask,final UpdateTaskRequest updateTaskRequest) {

        existTask.setTitle(updateTaskRequest.title());
        existTask.setDescription(updateTaskRequest.description());
        return existTask;
    }

   public TaskResponse toResponse( final Task task) {
       return new TaskResponse(task.getId(),
               task.getTitle(),
               task.getDescription(),
               task.getUser().getId()

       ) ;
   }

}
