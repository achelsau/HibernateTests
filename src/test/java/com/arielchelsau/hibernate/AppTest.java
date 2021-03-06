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
        CreditCard creditCard = ua.getCreditCard().get(0);
        System.out.println(creditCard.getCardNumber());
        System.out.println(creditCard.getOwner());
    }
}
