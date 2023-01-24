package org.fuckingtest.lol.service;

import java.util.List;
import java.util.stream.Collectors;
import org.fuckingtest.lol.domain.Accounts;
import org.fuckingtest.lol.dto.AccountsRequest;
import org.fuckingtest.lol.dto.AccountsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService {

  private final static Logger LOG = LoggerFactory.getLogger(AccountsServiceImpl.class);
  private DaoAccountRepo daoAccountRepo;


  @Override
  //@Lock(value = LockModeType.OPTIMISTIC_FORCE_INCREMENT)
  public List<AccountsResponse> findAll() {
    LOG.info("start find all");
    return daoAccountRepo.findAll().stream().map(this::getAccountsResponse).collect(Collectors.toList());
  }
private AccountsResponse getAccountsResponse(Accounts account){
    return AccountsResponse.builder()
        .lastLogin(account.getLastLogin())
        .user_id(account.getUser_id())
        .createdOn(account.getCreatedOn())
        .userName(account.getUserName())
        .password(account.getPassword())
        .email(account.getEmail())
        .build();
}
  @Override
  //@Lock(LockModeType.OPTIMISTIC)
 // @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
  public Accounts save(AccountsRequest accountsRequest) {
    Accounts accounts = Accounts.builder()
        .userName(accountsRequest.getUserName())
        .password(accountsRequest.getPassword())
        .email(accountsRequest.getEmail())
        .build();
    return daoAccountRepo.save(accounts);
  }


  @Autowired
  public void setDaoAccountRepo(DaoAccountRepo daoAccountRepo) {
    this.daoAccountRepo = daoAccountRepo;
  }
}
