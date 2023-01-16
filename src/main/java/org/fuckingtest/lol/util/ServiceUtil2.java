package org.fuckingtest.lol.util;

import org.springframework.stereotype.Service;

@Service
public class ServiceUtil2 implements LolService{

  @Override
  public String doIt() {
    return "test ServiceUtil2";
  }
}
