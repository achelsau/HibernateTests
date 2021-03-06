package com.arielchelsau.hibernate.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@ToString(exclude = {"owner"})
@Data
@NoArgsConstructor
@Entity
public class CreditCard {
  @Id
  @GeneratedValue
  private Long id;

  private String cardNumber;

  @EqualsAndHashCode.Exclude
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  @JoinColumn(name = "owner_id", nullable = true, updatable = false)
  private UserAccount owner;
}
