package org.fuckingtest.lol.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountsResponse {
  private String userName;
  private String email;
  private String password;
  private LocalDateTime createdOn;
  private LocalDateTime lastLogin;
  private Integer user_id;
}
