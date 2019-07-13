package com.demo.training.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class User {
  private String userId;
  private String name;
  private Date creationDate = new Date();
  private Map<String, String> userSetting = new HashMap<>();
}
