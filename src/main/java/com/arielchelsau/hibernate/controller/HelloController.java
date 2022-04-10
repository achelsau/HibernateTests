package com.arielchelsau.hibernate.controller;

import com.arielchelsau.hibernate.domain.CreditCard;
import com.arielchelsau.hibernate.domain.UserAccount;
import com.arielchelsau.hibernate.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

  @Autowired
  private UserAccountService userAccountService;

  @GetMapping("/")
  public String index() {
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername("ariel2");
    userAccount.setEmailAddress("ariel@yahoo.com");

    CreditCard cc1 = new CreditCard();
    cc1.setOwner(userAccount);
    cc1.setCardNumber("0980789009890808");

    CreditCard cc2 = new CreditCard();
    cc2.setOwner(userAccount);
    cc2.setCardNumber("0980789009890809");
    userAccount.setCreditCard(List.of(cc1, cc2));
    userAccount = userAccountService.saveUserAccount(userAccount);

    UserAccount ua = userAccountService.getUserAccount(userAccount.getId());
    System.out.println(ua.getCreditCard().get(0).getCardNumber());

    return "Greetings from Spring Boot!";
  }

}
