package com.arielchelsau.hibernate.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.Cascade;

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
import javax.persistence.Version;

@ToString(exclude = {"creditCard"})
@Data
@NoArgsConstructor
@Entity
public class UserAccount {
  @Id
  @GeneratedValue
  private Long id;

  private String username;

  private String emailAddress;

  @EqualsAndHashCode.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade= CascadeType.ALL)
  private List<CreditCard> creditCard = new ArrayList<>();

  @Version
  private Integer version;

}
