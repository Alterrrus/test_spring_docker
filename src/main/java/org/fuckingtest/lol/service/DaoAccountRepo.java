package org.fuckingtest.lol.service;

import org.fuckingtest.lol.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoAccountRepo extends JpaRepository<Accounts,Integer> {

}
