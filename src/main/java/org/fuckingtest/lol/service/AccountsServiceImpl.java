package org.fuckingtest.lol.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.LockModeType;
import org.fuckingtest.lol.colntrollers.UserController;
import org.fuckingtest.lol.domain.Accounts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountsServiceImpl implements AccountsService {

  private final static Logger LOG = LoggerFactory.getLogger(AccountsServiceImpl.class);
  private DaoAccountRepo daoAccountRepo;


  @Override
  //@Lock(value = LockModeType.OPTIMISTIC_FORCE_INCREMENT)
  public List<Accounts> findAll() {
    LOG.info("start find all");
    return daoAccountRepo.findAll();
  }

  @Override
  //@Lock(LockModeType.OPTIMISTIC)
  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
  public Accounts save(Accounts accounts) {

    return daoAccountRepo.save(accounts);
  }


  @Autowired
  public void setDaoAccountRepo(DaoAccountRepo daoAccountRepo) {
    this.daoAccountRepo = daoAccountRepo;
  }
}
