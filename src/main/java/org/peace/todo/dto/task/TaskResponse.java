package org.peace.todo.dto.task;

import java.util.UUID;

public record TaskResponse(
        UUID id,
        String title,
        String description,
        UUID userId
) {}