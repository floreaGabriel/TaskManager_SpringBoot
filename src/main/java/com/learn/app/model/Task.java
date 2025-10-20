package com.learn.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tasks") // tabel name optional
public class Task {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
  private Long id;

  @NotBlank(message = "Title is required")
  @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
  @Column(nullable = false, length = 100) // column definition
  private String title;

  @Size(max = 500, message = "Description cannot exceed 500 characters")
  @Column(length = 500)
  private String description;
  
  @Column(nullable = false)
  private boolean completed = false; // default val

  // Constructors
  
  public Task() {}

  public Task(String title, String description) {
    this.title = title;
    this.description = description;
  }

  // Getters and Setters
  
  public Long getId() { return this.id; }
  public void setId(Long id) { this.id = id; }
  public String getTitle() { return this.title; }
  public void setTitle(String title) { this.title = title; }
  public String getDescription() { return this.description; }
  public void setDescription(String description) { this.description = description; }
  public boolean isCompleted() { return completed; }
  public void setCompleted(boolean completed) { this.completed = completed; }
  
  // ========================================
  // toString() - pentru debugging & logging
  // ========================================
  @Override
  public String toString() {
    return "Task{" +
           "id=" + id +
           ", title='" + title + '\'' +
           ", description='" + description + '\'' +
           ", completed=" + completed +
           '}';
  }
}
