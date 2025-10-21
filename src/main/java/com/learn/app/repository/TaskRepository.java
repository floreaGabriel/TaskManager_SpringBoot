package com.learn.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.app.model.Task;

/*
 * Clasa care gestioneaza CRUD automat
 * Ascunde codul SQL efectiv
 * */

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  // ========================================
  // METODE BUILT-IN (from JpaRepository)
  // ========================================
  
  // save(Task task) 
  // findById(Long id) 
  // findAll() -urile
  // deleteById(Long id) 
  // count() 
  // existsById(Long id) 
  
  
  // ========================================
  // CUSTOM QUERY METHODS
  // ========================================
 
  List<Task> findByCompleted(boolean completed);
  Optional<Task> findByTitle(String title);

  // ========================================
  // @Query - pentru query-uri complexe
  // ========================================

  /**
   * JPQL Query (Java Persistence Query Language)
   * Folosește numele claselor și proprietăților, nu tabelelor
   */
  // @Query("SELECT t FROM Task t WHERE t.completed = :status")
  // List<Task> findTasksByStatus(@Param("status") boolean status);
}
