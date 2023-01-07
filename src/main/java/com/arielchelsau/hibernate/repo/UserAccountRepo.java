package com.arielchelsau.hibernate.repo;

import com.arielchelsau.hibernate.domain.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
public class UserAccountRepo {

  @Autowired
  private EntityManager entityManager;

  public UserAccount saveUserAccount(UserAccount userAccount) {
    return entityManager.merge(userAccount);
  }

  public Optional<UserAccount> getUserAccount(Long id) {
    Optional<UserAccount> userAccount = Optional.ofNullable(entityManager.find(UserAccount.class, id));
    return userAccount;
  }

  public void deleteUserAccount(UserAccount userAccount) {
    entityManager.remove(userAccount);
  }


  public UserAccount getUserAccountById(Long id) {
    try {
      TypedQuery<UserAccount> query = entityManager
          .createQuery("select ua from UserAccount ua where ua.id = :id", UserAccount.class);
      query.setParameter("id", id);

      return query.getSingleResult();
    } catch (NoResultException exception) {
      return null;
    }
  }
}
