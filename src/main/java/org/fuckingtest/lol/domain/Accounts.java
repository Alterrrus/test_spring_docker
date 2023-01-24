package org.fuckingtest.lol.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

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

  @Builder
  public Accounts(String userName, String email, String password) {
    this.userName = userName;
    this.email = email;
    this.createdOn = LocalDateTime.now();
    this.password = password;
  }

}
