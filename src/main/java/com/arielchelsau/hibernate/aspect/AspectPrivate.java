package com.arielchelsau.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectPrivate {
  @Pointcut("execution(private * withTemporarySessionIfNeeded(..))")
  public void anyPrivateMethod() {}

  @Before("anyPrivateMethod()")
  public void beforePrivateMethod(JoinPoint jp) {
    System.out.println("Before a private method...");
  }
}
