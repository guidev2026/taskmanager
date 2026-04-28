package com.portifolio.taskmanager.controller;

import com.portifolio.taskmanager.dto.request.TaskRequestDTO;
import com.portifolio.taskmanager.dto.response.TaskResponseDTO;
import com.portifolio.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> salvar(@RequestBody @Valid TaskRequestDTO dto) {
        TaskResponseDTO response = taskService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> listarTodos() {
        return ResponseEntity.ok(taskService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(taskService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TaskRequestDTO dto){
        return ResponseEntity.ok(taskService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
