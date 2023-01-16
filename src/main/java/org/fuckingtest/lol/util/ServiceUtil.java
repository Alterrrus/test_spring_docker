package org.fuckingtest.lol.util;

import org.springframework.stereotype.Service;


@Service
public class ServiceUtil implements LolService{

  @Override
  public String doIt() {

    return "temp string test";
  }
}
