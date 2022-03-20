package com.arielchelsau.hibernate;


import com.arielchelsau.hibernate.domain.CreditCard;
import com.arielchelsau.hibernate.domain.UserAccount;
import com.arielchelsau.hibernate.repo.UserAccountRepo;
import com.arielchelsau.hibernate.service.UserAccountService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private UserAccountService userAccountService;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("ariel2");
        userAccount.setEmailAddress("ariel@yahoo.com");

        UserAccount userAccount3 = new UserAccount();
        userAccount3.setUsername("ariel3");
        userAccount3.setEmailAddress("ariel@yahoo.com");

        CreditCard cc2 = new CreditCard();
        cc2.setOwner(userAccount);
        cc2.setCardNumber("0980789009890809");
        userAccount.setCreditCard(List.of(cc2));
        //userAccountRepo.saveUserAccount(userAccount);

        //userAccountService.saveUserAccount(userAccount);

        UserAccount ua = userAccountRepo.getUserAccount(1L).get();
        System.out.println(ua);

        /*UserAccount ua = userAccountRepo.getUserAccountById(41L);
        System.out.println("UA cc: " + ua.getCreditCards());*/
    }
}
