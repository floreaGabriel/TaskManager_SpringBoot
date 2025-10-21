package com.learn.app.dto;

import java.time.LocalDateTime;

import com.learn.app.model.Task.Priority;

public class TaskResponseDTO {
    
  private Long id;
  private String title;
  private String description;
  private boolean completed;
  private Priority priority;
  private String category; 
  private LocalDateTime createdAt;
  private LocalDateTime deadline;

  // constructor default
  public TaskResponseDTO() {}
  
  public TaskResponseDTO(Long id, String title, String description, Priority priority, String category, LocalDateTime createdAt, LocalDateTime deadline ,boolean completed) {
    this.id = id; 
    this.title = title;
    this.description = description;
    this.completed = completed;
    this.priority = priority;
    this.category = category;
    this.createdAt = createdAt;
    this.deadline = deadline;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public boolean isCompleted() { return completed; }
  public void setCompleted(boolean completed) { this.completed = completed; }
  
  public Priority getPriority() { return priority; }
  public void setPriority(Priority priority) { this.priority = priority; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public LocalDateTime getCreatedAt() { return this.createdAt; }
  public LocalDateTime getDeadline() { return deadline; }
  public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
}
