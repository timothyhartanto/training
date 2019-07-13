package com.demo.training;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = {"com.demo.training"})
public class TrainingApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(TrainingApplication.class).run(args);
  }

}

