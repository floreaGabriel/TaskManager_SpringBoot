package com.learn.app.dto;

import java.time.LocalDateTime;

import com.learn.app.model.Task.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponseDTO {
    
  private Long id;
  private String title;
  private String description;
  private boolean completed;
  private Priority priority;
  private String category; 
  private LocalDateTime createdAt;
  private LocalDateTime deadline;

  private Long userId;
  private String username;

}
