package com.portifolio.taskmanager.model.entity;

import com.portifolio.taskmanager.model.enums.TaskPriority;
import com.portifolio.taskmanager.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @CreationTimestamp
    private Instant createdAt;

    private Instant dueDate;
}
