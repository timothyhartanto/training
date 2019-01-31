package com.demo.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.demo.training"})
public class TrainingApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrainingApplication.class, args);
  }

}

