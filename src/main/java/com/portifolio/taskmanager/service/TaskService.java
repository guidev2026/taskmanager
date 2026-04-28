package com.portifolio.taskmanager.service;

import com.portifolio.taskmanager.dto.request.TaskRequestDTO;
import com.portifolio.taskmanager.dto.response.TaskResponseDTO;
import com.portifolio.taskmanager.exceptions.ResourceNotFoundException;
import com.portifolio.taskmanager.model.entity.Task;
import com.portifolio.taskmanager.model.enums.TaskStatus;
import com.portifolio.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDTO salvar(TaskRequestDTO dto){
        Task taskEntity = new Task();

        taskEntity.setTitle(dto.title());
        taskEntity.setDescription(dto.description());
        taskEntity.setStatus(TaskStatus.PENDENTE);
        taskEntity.setPriority(dto.priority());

        Task taskSaved = taskRepository.save(taskEntity);

        return converterParaDTO(taskSaved);
    }

    public List<TaskResponseDTO> listarTodos(){
        return taskRepository.findAll()
                .stream()
                .map( task -> converterParaDTO(task))
                .toList();
    }

    public TaskResponseDTO buscarPorId(Long id){
        Task task = buscarPorIdEntity(id);

        return converterParaDTO(task);
    }

    public TaskResponseDTO atualizar(Long id, TaskRequestDTO dto){
        Task task = buscarPorIdEntity(id);

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());

        Task taskAtualizada = taskRepository.save(task);

        return converterParaDTO(taskAtualizada);
    }

    public void deletar(Long id){
        Task task = buscarPorIdEntity(id);

        taskRepository.delete(task);
    }

    private TaskResponseDTO converterParaDTO(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt(),
                task.getDueDate()
        );
    }

    private Task buscarPorIdEntity(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task não encontrada"));
    }
}
