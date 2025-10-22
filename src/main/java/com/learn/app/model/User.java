package com.learn.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  public User() {}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters Setters
  public Long getId() { return this.id; }
  public void setId(Long id) { this.id = id; }
  public String getUsername() { return this.username; }
  public void setUsername(String username) { this.username = username; }
  public String getPassword() { return this.password; }
  public void setPassword(String password) { this.password = password; }

  public String toString() {
    return "User {" +
      "id = " + this.id + " | " +
      "username = " + this.username + "}";
  }
}

