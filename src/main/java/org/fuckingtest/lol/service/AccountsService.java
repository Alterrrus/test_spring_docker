package org.fuckingtest.lol.service;

import java.util.List;
import org.fuckingtest.lol.domain.Accounts;
import org.springframework.stereotype.Service;


public interface AccountsService {
  List<Accounts> findAll();
  Accounts save(Accounts accounts);

}
