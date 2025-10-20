package com.learn.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.app.model.Task;
import com.learn.app.repository.TaskRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class TaskManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TaskManagerApplication.class, args);
  }
  
  @Bean
  CommandLineRunner testRepository(TaskRepository repository) {
    return args -> {
      // create task
      Task t1 = new Task("Learn Spring Boot", "Complete Tutorial");
      Task t2 = new Task("Learn python", "Complete Tutorial python");
      
      repository.save(t1);
      repository.save(t2);

      System.out.println("All tasks: " + repository.findByTitle("Learn Spring Boot"));
      System.out.println("Incomplete: " + repository.findByCompleted(false));
    };
  }
}
