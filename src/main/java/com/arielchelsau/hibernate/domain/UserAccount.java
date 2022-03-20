package com.arielchelsau.hibernate.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@Entity
public class UserAccount {
  @Id
  @GeneratedValue
  private Long id;

  private String username;

  private String emailAddress;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade= CascadeType.MERGE)
  private List<CreditCard> creditCard = new ArrayList<>();

}
