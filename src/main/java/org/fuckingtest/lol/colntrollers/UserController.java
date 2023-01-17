package org.fuckingtest.lol.colntrollers;

import java.time.LocalDateTime;
import java.util.List;
import org.fuckingtest.lol.domain.Accounts;
import org.fuckingtest.lol.kafkaservice.KafkaProducerService;
import org.fuckingtest.lol.service.AccountsService;
import org.fuckingtest.lol.util.LolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final static Logger LOG = LoggerFactory.getLogger(UserController.class);
  private AccountsService accountsServiceImpl;

  private KafkaProducerService kafkaProducerServiceImpl;

  @GetMapping("/all")
  public ResponseEntity<List<Accounts>> getAllUsers() {
    try {
      Accounts a = new Accounts("as","as", LocalDateTime.now(),"as");
      Thread.sleep(2000);
      accountsServiceImpl.save(a);
      Accounts d = new Accounts("asa","asa", LocalDateTime.now(), "ds");
      accountsServiceImpl.save(d);
      Thread.sleep(2000);
      Accounts c = new Accounts("ass","ass", LocalDateTime.now(), "yt");
      Thread.sleep(2000);
      accountsServiceImpl.save(c);
      Accounts f = new Accounts("asd","asfdsasd", LocalDateTime.now(), "tr");
      Thread.sleep(2000);
      accountsServiceImpl.save(f);

      kafkaProducerServiceImpl.sendMessage("тестовое сообщение в кафку");

      return ResponseEntity.ok(accountsServiceImpl.findAll());
    } catch (Exception ex) {
      LOG.error(ex.getMessage());
      return ResponseEntity.badRequest().build();
      //return ResponseEntity.badRequest().body(String.format("Exception %s", ex));
    }
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
