package com.arielchelsau.hibernate.service;

import com.arielchelsau.hibernate.domain.UserAccount;
import com.arielchelsau.hibernate.repo.UserAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserAccountService {

  @Autowired
  private UserAccountRepo userAccountRepo;

  @Transactional
  public void saveUserAccount(UserAccount ua) {
    userAccountRepo.saveUserAccount(ua);
  }
}
