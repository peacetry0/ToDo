package org.peace.todo.dto.task;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(
        @NotBlank
        String title,
        String description
) {}