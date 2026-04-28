package com.portifolio.taskmanager.dto.request;

import com.portifolio.taskmanager.model.enums.TaskPriority;
import com.portifolio.taskmanager.model.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record TaskRequestDTO(
        @NotBlank(message = "O titulo é obrigatorio")
        String title,

        String description,

        @NotNull(message = "O status é obrigatorio")
        TaskStatus status,

        @NotNull(message = "A prioridade é obrigatoria")
        TaskPriority priority,

        @FutureOrPresent(message = "A data de entrga não pode ser no passado")
        Instant dueDate
) {
}
