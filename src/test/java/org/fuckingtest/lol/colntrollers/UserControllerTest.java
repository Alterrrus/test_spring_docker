package org.fuckingtest.lol.colntrollers;

import static org.apache.coyote.http11.Constants.a;
import static org.junit.jupiter.api.Assertions.*;

import org.fuckingtest.lol.util.LolService;
import org.fuckingtest.lol.util.ServiceUtil;
import org.fuckingtest.lol.util.ServiceUtil2;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class UserControllerTest {
  @Autowired
  LolService serviceUtil;
  @Autowired
  LolService serviceUtil2;

  @Test
  void getAllUsers() {

    String a = serviceUtil.doIt();
    String b = serviceUtil2.doIt();
    assertNotEquals(a, b);
    //assertEquals(a, b);

  }


}
