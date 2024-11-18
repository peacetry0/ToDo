package org.peace.todo.dto.task;

import jakarta.validation.constraints.NotBlank;

public record UpdateTaskRequest(
        @NotBlank
        String title,
        String description) {
}
