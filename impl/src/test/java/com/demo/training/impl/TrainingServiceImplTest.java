package com.demo.training.impl;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import javafx.util.Pair;

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

  public int trap(List<Integer> height) {
    if(height.size() <= 0)
      return 0;
    int res = 0;
    int startingPoint = height.get(0);
    Stack<Integer> des = new Stack<>();

    for (int i = 1; i < height.size(); i++) {
      if (height.get(i) < startingPoint) {
        if (!des.isEmpty() && des.peek() < height.get(i)) {
          res += height.get(i) - des.pop();
          des.push(height.get(i));
        }
        des.push(height.get(i));
      } else if (height.get(i) >= startingPoint) {
        while (!des.isEmpty()) {
          res += startingPoint - des.pop();
        }
        startingPoint = height.get(i);
      }
    }
    return res;
  }

  @Test
  public void test1() throws Exception {
    long startTime = System.currentTimeMillis();
    //    List<Integer> A = Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1);

    long endTime = System.currentTimeMillis();
    long seconds = (endTime - startTime);
    System.out.println(seconds);

    //    int x = 5;
    //    x = ~x;
  }

}