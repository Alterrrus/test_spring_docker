package org.fuckingtest.lol.service;

import java.util.List;
import org.fuckingtest.lol.domain.Accounts;
import org.fuckingtest.lol.dto.AccountsRequest;
import org.fuckingtest.lol.dto.AccountsResponse;


public interface AccountsService {
  List<AccountsResponse> findAll();
  Accounts save(AccountsRequest accountsRequest);

}
