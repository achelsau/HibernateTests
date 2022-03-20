package com.arielchelsau.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NewEnt {
  @Id
  @GeneratedValue
  private Long id;

  private String col;
}
