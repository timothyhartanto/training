package com.demo.training.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPAspect {
  @Before("execution(* com.demo.training.impl.TrainingServiceImpl.simpleMethod())")
  public void beforeExecuting() {
    System.out.println("Before everything");
  }

}
