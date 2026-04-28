package com.portifolio.taskmanager.repository;

import com.portifolio.taskmanager.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
