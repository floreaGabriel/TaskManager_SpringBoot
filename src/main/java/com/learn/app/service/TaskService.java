package com.learn.app.service;

import java.util.List;
import java.util.stream.Collectors;

import com.learn.app.model.User;
import com.learn.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.learn.app.dto.TaskCreateDTO;
import com.learn.app.dto.TaskResponseDTO;
import com.learn.app.model.Task;
import com.learn.app.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service // marcheaza aceasta clasa drept un serviciu Spring
public class TaskService {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;
  
  // constructor 
  public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
  }

  @Transactional
  public TaskResponseDTO createTask(Long userId, TaskCreateDTO dto) {


    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

    Task task = new Task();

    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setCompleted(false);
    task.setPriority(dto.getPriority());
    task.setCategory(dto.getCategory());
    task.setDeadline(dto.getDeadline());
    task.setUser(user);


    Task savedTask = taskRepository.save(task);

    // mapare cu DTO
    return new TaskResponseDTO(
      savedTask.getId(),
      savedTask.getTitle(),
      savedTask.getDescription(),
      savedTask.isCompleted(),
      savedTask.getPriority(),
      savedTask.getCategory(),
      savedTask.getCreatedAt(),
      savedTask.getDeadline(),
      savedTask.getUser().getId(),
      savedTask.getUser().getUsername()
    );
  }

  public List<TaskResponseDTO> getAllTasks() {
    return taskRepository.findAll().stream()
      .map(task -> new TaskResponseDTO(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.isCompleted(),
        task.getPriority(),
        task.getCategory(),
        task.getCreatedAt(),
        task.getDeadline(),
        task.getUser().getId(),
        task.getUser().getUsername()
    )).toList();
  }


  public List<TaskResponseDTO> getAllTasksByUserId(Long userId) {
    return taskRepository.findByUserId(userId)
            .stream().map(task -> new TaskResponseDTO(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.isCompleted(),
                    task.getPriority(),
                    task.getCategory(),
                    task.getCreatedAt(),
                    task.getDeadline(),
                    task.getUser().getId(),
                    task.getUser().getUsername()
            )).collect(Collectors.toList());
  }

  public TaskResponseDTO updateTask(Long taskId, Long userId, TaskCreateDTO dto) {
    Task task = taskRepository.findByIdAndUserId(taskId, userId)
            .orElseThrow(() -> new RuntimeException("Task not found or access denied"));

    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());

    Task updatedTask = taskRepository.save(task);
    return new TaskResponseDTO(
            updatedTask.getId(),
            updatedTask.getTitle(),
            updatedTask.getDescription(),
            updatedTask.isCompleted(),
            updatedTask.getPriority(),
            updatedTask.getCategory(),
            updatedTask.getCreatedAt(),
            updatedTask.getDeadline(),
            updatedTask.getUser().getId(),
            updatedTask.getUser().getUsername()
    );
  }
  public TaskResponseDTO toggleCompleted(Long taskId, Long userId) {
    Task task = taskRepository.findByIdAndUserId(taskId, userId)
            .orElseThrow(() -> new RuntimeException("Task not found or access denied"));

    task.setCompleted(!task.isCompleted());

    Task updatedTask = taskRepository.save(task);
    return new TaskResponseDTO(
            updatedTask.getId(),
            updatedTask.getTitle(),
            updatedTask.getDescription(),
            updatedTask.isCompleted(),
            updatedTask.getPriority(),
            updatedTask.getCategory(),
            updatedTask.getCreatedAt(),
            updatedTask.getDeadline(),
            updatedTask.getUser().getId(),
            updatedTask.getUser().getUsername()
    );
  }

  public void deleteTask(Long taskId, Long userId) {
    Task task = taskRepository.findByIdAndUserId(taskId, userId)
            .orElseThrow(() -> new RuntimeException("Task not found or access denied"));
    taskRepository.delete(task);
  }

}
