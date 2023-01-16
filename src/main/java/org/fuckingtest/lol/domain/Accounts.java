package org.fuckingtest.lol.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "accounts")
public class Accounts {

  public Accounts() {

  }


  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "user_id", nullable = false, unique = true)
  private Integer user_id;
  @Column(name = "USERNAME")
  private String userName;
  @Column(name = "password")
  private String password;
  private String email;
  @Column(name = "created_on")

  private LocalDateTime createdOn;
  @Column(name = "last_login")
  private LocalDateTime lastLogin;
  @Version
  private Long version;

  public Accounts(String userName, String email, LocalDateTime createdOn, String password) {
    this.userName = userName;
    this.email = email;
    this.createdOn = createdOn;
    this.password = password;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }
  @Column(name = "USERNAME")

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public LocalDateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(LocalDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
