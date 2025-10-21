package com.learn.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.app.dto.TaskCreateDTO;
import com.learn.app.dto.TaskResponseDTO;
import com.learn.app.model.Task;
import com.learn.app.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service // marcheaza aceasta clasa drept un serviciu Spring
public class TaskService {

  private final TaskRepository taskRepository;
  
  // constructor 
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Transactional
  public TaskResponseDTO createTask(TaskCreateDTO dto) {
    
    Task task = new Task();

    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setCompleted(false);
    task.setPriority(dto.getPriority());
    task.setCategory(dto.getCategory());
    task.setDeadline(dto.getDeadline());


    Task savedTask = taskRepository.save(task);

    // mapare cu DTO
    return new TaskResponseDTO(
      savedTask.getId(),
      savedTask.getTitle(),
      savedTask.getDescription(),
      savedTask.getPriority(),
      savedTask.getCategory(),
      savedTask.getCreatedAt(),
      savedTask.getDeadline(),
      savedTask.isCompleted()
    );
  }

  public List<TaskResponseDTO> getAllTasks() {
    return taskRepository.findAll().stream()
      .map(task -> new TaskResponseDTO(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getPriority(),
        task.getCategory(),
        task.getCreatedAt(),
        task.getDeadline(),
        task.isCompleted()
    )).toList();
  }
  

}
