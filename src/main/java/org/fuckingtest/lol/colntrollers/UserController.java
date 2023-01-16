package org.fuckingtest.lol.colntrollers;

import java.time.LocalDateTime;
import org.fuckingtest.lol.domain.Accounts;
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
  private LolService serviceUtil;
  private LolService serviceUtil2;
  private AccountsService accountsServiceImpl;

  @GetMapping("/all")
  public ResponseEntity getAllUsers() {
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

      return ResponseEntity.ok(accountsServiceImpl.findAll());
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body(String.format("Exception %s", ex.toString()));
    }
  }

  @Autowired
  public void setServiceUtil(LolService serviceUtil) {
    this.serviceUtil = serviceUtil;
  }

  @Autowired
  public void setServiceUtil2(LolService serviceUtil2) {
    this.serviceUtil2 = serviceUtil2;
  }

  @Autowired
  public void setAccountsServiceImpl(AccountsService accountsServiceImpl) {
    this.accountsServiceImpl = accountsServiceImpl;
  }
}
