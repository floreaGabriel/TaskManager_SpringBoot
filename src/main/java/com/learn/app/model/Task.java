package com.learn.app.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;


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
