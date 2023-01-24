package org.fuckingtest.lol;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.fuckingtest.lol.dto.AccountsRequest;
import org.fuckingtest.lol.service.AccountsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@Slf4j
class LolApplicationTests {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private AccountsService accountsServiceImpl;

  @Test
  void shouldCreateProduct() throws Exception {

      AccountsRequest accountsRequest = getAccountRequest();
      //accountsServiceImpl.save(accountsRequest);
      String accountRequestString = objectMapper.writeValueAsString(accountsRequest);
      mockMvc.perform(MockMvcRequestBuilders.post("/users/user")
              .contentType(MediaType.APPLICATION_JSON)
              .content(accountRequestString))
          .andExpect(status().isCreated());

      Assertions.assertEquals(1, accountsServiceImpl.findAll().size());
    }

  private AccountsRequest getAccountRequest(){
    return AccountsRequest.builder()
        .email("andrey@andrey.ru")
        .userName("andrey")
        .password("andrey")
        .build();
  }

}
