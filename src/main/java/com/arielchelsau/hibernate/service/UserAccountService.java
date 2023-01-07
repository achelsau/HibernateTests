package com.arielchelsau.hibernate.service;

import com.arielchelsau.hibernate.domain.UserAccount;
import com.arielchelsau.hibernate.events.CustomSpringEventPublisher;
import com.arielchelsau.hibernate.repo.UserAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class UserAccountService {

  @Autowired
  private UserAccountRepo userAccountRepo;

  @Autowired
  private CustomSpringEventPublisher customSpringEventPublisher;

  @Transactional
  public UserAccount saveUserAccount(UserAccount ua) {
    customSpringEventPublisher.publishCustomEvent("Test");
    return userAccountRepo.saveUserAccount(ua);
  }

  @Transactional
  public UserAccount getUserAccount(Long id) {
    Optional<UserAccount> userAccount = userAccountRepo.getUserAccount(id);
    return userAccount.get();
  }

  @Transactional
  public void deleteUserAccounts(Long userId) {
    UserAccount userAccountById = userAccountRepo.getUserAccountById(userId);
    userAccountRepo.deleteUserAccount(userAccountById);
  }

  @Transactional
  public void deleteUserAccount(UserAccount ua) {
    userAccountRepo.deleteUserAccount(ua);
  }
}
