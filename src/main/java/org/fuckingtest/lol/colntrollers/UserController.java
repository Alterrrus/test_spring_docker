package org.fuckingtest.lol.colntrollers;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.fuckingtest.lol.dto.AccountsRequest;
import org.fuckingtest.lol.dto.AccountsResponse;
import org.fuckingtest.lol.kafkaservice.KafkaProducerService;
import org.fuckingtest.lol.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  //private final static Logger LOG = LoggerFactory.getLogger(UserController.class);
  private AccountsService accountsServiceImpl;

  private KafkaProducerService kafkaProducerServiceImpl;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<AccountsResponse> getAllUsers() {
    try {
      //kafkaProducerServiceImpl.sendMessage("тестовое сообщение в кафку");
      return accountsServiceImpl.findAll();
    } catch (Exception ex) {
      log.error(ex.getMessage());
      return Collections.emptyList();
    }
  }

  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@RequestBody AccountsRequest accountsRequest, HttpServletRequest request){
    accountsServiceImpl.save(accountsRequest);

    log.info(request.getPathInfo());
    log.info(request.getContextPath());
    log.info(request.getRequestURI());
    log.info(request.getRequestURL().toString());
  }

  @Autowired
  public void setAccountsServiceImpl(AccountsService accountsServiceImpl) {
    this.accountsServiceImpl = accountsServiceImpl;
  }
  @Autowired

  public void setKafkaProducerServiceImpl(KafkaProducerService kafkaProducerServiceImpl) {
    this.kafkaProducerServiceImpl = kafkaProducerServiceImpl;
  }
}
