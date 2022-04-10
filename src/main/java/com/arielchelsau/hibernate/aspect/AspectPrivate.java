package com.arielchelsau.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectPrivate {
  @Pointcut("execution(* org.hibernate.collection.internal.PersistentBag.get(..))")
  public void anyPrivateMethod() {}

  @Before("anyPrivateMethod()")
  public void beforePrivateMethod(JoinPoint jp) {
    System.out.println("Before a private method..." + jp.getSignature());
  }
}
