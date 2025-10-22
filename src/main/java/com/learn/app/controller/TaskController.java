package com.learn.app.controller;

import java.util.List;

import com.learn.app.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.app.dto.TaskCreateDTO;
import com.learn.app.dto.TaskResponseDTO;
import com.learn.app.service.TaskService;


@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
  private final TaskService taskService;
  private final JwtUtil jwtUtil;
  private Long getCurrentUserId() {
    return 1L; // ID-ul user-ului din baza de date
  }

  private Long getCurrentUserId(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      String token = authHeader.substring(7);
      return jwtUtil.extractUserId(token);
    }
    throw new RuntimeException("JWT token not found");
  }


  @PostMapping
  public ResponseEntity<TaskResponseDTO> createTask(
          @Valid @RequestBody TaskCreateDTO dto,
          HttpServletRequest request) {
    Long userId = getCurrentUserId(request);
    TaskResponseDTO response = taskService.createTask(userId, dto);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TaskResponseDTO>> getAllTasks(HttpServletRequest request) {
    Long userId = getCurrentUserId(request);
    List<TaskResponseDTO> tasks = taskService.getAllTasksByUserId(userId);
    return ResponseEntity.ok(tasks);
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTask(
          @PathVariable Long taskId,
          HttpServletRequest request) {
    Long userId = getCurrentUserId(request);
    taskService.deleteTask(taskId, userId);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{taskId}")
  public ResponseEntity<TaskResponseDTO> updateTask(
          @PathVariable Long taskId,
          @Valid @RequestBody TaskCreateDTO dto,
          HttpServletRequest request) {
    Long userId = getCurrentUserId(request);
    TaskResponseDTO response = taskService.updateTask(taskId, userId, dto);
    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{taskId}/toggle")
  public ResponseEntity<TaskResponseDTO> toggleCompleted(
          @PathVariable Long taskId,
          HttpServletRequest request) {
    Long userId = getCurrentUserId(request);
    TaskResponseDTO response = taskService.toggleCompleted(taskId, userId);
    return ResponseEntity.ok(response);
  }
}
