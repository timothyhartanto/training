package com.demo.training.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class InnerModel extends TestModel {
  private String child;

//  @Override
//  public String print() {
//    return "inner";
//  }
}
