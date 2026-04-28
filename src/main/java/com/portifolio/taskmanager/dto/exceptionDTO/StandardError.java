package com.portifolio.taskmanager.dto.exceptionDTO;

import java.time.Instant;

public record StandardError(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
