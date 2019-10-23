package com.demo.training.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestModel {
  String name;
  int number;
  InnerModel innerModel;
//  public String print() {
//    return "test";
//  }
}
