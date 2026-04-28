package com.portifolio.taskmanager.dto.response;

import com.portifolio.taskmanager.model.enums.TaskPriority;
import com.portifolio.taskmanager.model.enums.TaskStatus;

import java.time.Instant;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        Instant createdAt,
        Instant dueDate
) {
}
