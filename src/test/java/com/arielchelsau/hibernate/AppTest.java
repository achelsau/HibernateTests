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

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

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
        userAccount.setUsername("ariel3");
        userAccount.setEmailAddress("ariel@yahoo.com");

        CreditCard cc1 = new CreditCard();
        cc1.setOwner(userAccount);
        cc1.setCardNumber("0980789009890808");

        CreditCard cc2 = new CreditCard();
        cc2.setOwner(userAccount);
        cc2.setCardNumber("0980789009890809");
        userAccount.setCreditCard(List.of(cc1, cc2));
        userAccount = userAccountService.saveUserAccount(userAccount);

        userAccountService.saveUserAccount(userAccount);

        //userAccountService.deleteUserAccounts(userAccount.getId());

        /*CreditCard creditCard = userAccount.getCreditCard().get(0);
        System.out.println(creditCard.getCardNumber());
        System.out.println(creditCard.getOwner());*/
        UserAccount userAccount1 = userAccountService.getUserAccount(userAccount.getId());
        System.out.println("Version of UA: " + userAccount1.getVersion());
        userAccount1.setUsername("Bla");
        UserAccount userAccount2 = userAccountService.getUserAccount(userAccount.getId());
        userAccountService.saveUserAccount(userAccount1);
        userAccount2.setUsername("Bla 2");
        userAccountService.saveUserAccount(userAccount2);
        System.out.println("Version of UA: " + userAccount2.getVersion());
    }
}
