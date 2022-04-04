package com.arielchelsau.hibernate.service;

import com.arielchelsau.hibernate.domain.UserAccount;
import com.arielchelsau.hibernate.repo.UserAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class UserAccountService {

  @Autowired
  private UserAccountRepo userAccountRepo;

  @Transactional
  public UserAccount saveUserAccount(UserAccount ua) {
    return userAccountRepo.saveUserAccount(ua);
  }

  @Transactional
  public UserAccount getUserAccount(Long id) {
    Optional<UserAccount> userAccount = userAccountRepo.getUserAccount(id);
    return userAccount.get();
  }
}
