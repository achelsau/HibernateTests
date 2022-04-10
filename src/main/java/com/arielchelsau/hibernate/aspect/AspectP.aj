package com.arielchelsau.hibernate.aspect;

import org.hibernate.collection.internal.AbstractPersistentCollection;

public aspect AspectP {
  pointcut callOpenTemporarySessionForLoading() :
      call(* AbstractPersistentCollection.openTemporarySessionForLoading());

  before() : callOpenTemporarySessionForLoading() {
    System.out.println("Temporary Session Opened for Loading!!!");
  }
}
