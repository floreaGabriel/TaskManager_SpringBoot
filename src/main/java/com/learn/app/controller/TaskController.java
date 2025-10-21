package com.learn.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.app.dto.TaskCreateDTO;
import com.learn.app.dto.TaskResponseDTO;
import com.learn.app.service.TaskService;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping // POST  /api/tasks 
  public TaskResponseDTO createTask(@RequestBody TaskCreateDTO dto) {
    return taskService.createTask(dto);
  }

  @GetMapping
  public List<TaskResponseDTO> getAllTasks() {
    return taskService.getAllTasks();
  }


}
