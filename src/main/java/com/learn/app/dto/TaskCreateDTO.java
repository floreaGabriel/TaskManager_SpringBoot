package com.learn.app.dto;

import java.time.LocalDateTime;

import com.learn.app.model.Task.Priority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskCreateDTO {

  @NotBlank(message = "Title is required")
  @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
  private String title;

  @Size(max = 500, message = "Description cannot exceed 500 characters")
  private String description;

  private Priority priority = Priority.LOW;
  private String category = "General";
  private LocalDateTime deadline;
  // Constructori

  public TaskCreateDTO() {}
  public TaskCreateDTO(String title, String description, Priority priority, String category ,LocalDateTime deadline) {
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.category = category;
    this.deadline = deadline;
  }


  // getter si setter

  public String getTitle() { return this.title; }
  public void setTitle(String title) { this.title = title; }
  public String getDescription() { return this.description; }
  public void setDescription(String description) { this.description = description; }

  public Priority getPriority() { return priority; }
  public void setPriority(Priority priority) { this.priority = priority; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public LocalDateTime getDeadline() { return deadline; }
  public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
}
