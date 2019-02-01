package com.demo.training.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestModel {
  String name;
  int number;
}
