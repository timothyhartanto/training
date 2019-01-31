package com.demo.training.impl;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TrainingServiceImplTest {

  @InjectMocks
  private TrainingServiceImpl trainingService;

  @Before
  public void setUp() throws Exception {
    initMocks(this);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test1() {
    //    trainingService.simpleMethod();
    Map<String, String> test = new HashMap<>();
    test.put("key1", "value1");
    test.put("key2", "value2");
    test.put("key3", "value3");
    for (Map.Entry<String, String> data : test.entrySet()) {
      System.out.println(data.getKey() + " " + data.getValue());
    }

  }

}