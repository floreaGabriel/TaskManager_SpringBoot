package com.learn.app.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



/*
 * Clasa care modeleaza o entitate din baza de date
 * Defineste practic o tabela
*/
@Entity
@Table(name = "tasks") // tabel name optional
public class Task {
  
  public enum Priority {
    LOW, MEDIUM, HIGH
  }
  
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

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Priority priority = Priority.LOW;

  @Column(nullable = false, length = 50)
  private String category = "General";

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;
  
  @Column
  private LocalDateTime deadline;
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


  // Getters și setters pentru noile câmpuri
  public Priority getPriority() { return priority; }
  public void setPriority(Priority priority) { this.priority = priority; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public LocalDateTime getCreatedAt() { return this.createdAt; }

  public LocalDateTime getDeadline() { return deadline; }
  public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
  
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
