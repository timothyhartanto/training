package com.demo.training.impl;

import static org.mockito.MockitoAnnotations.initMocks;

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

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = nums1.length - 1;
    m--;
    n--;

    while(m > 0 || n > 0) {
      if(n < 0) {
        nums1[index--] = nums1[m--];
      } else if (m < 0) {
        nums1[index--] = nums2[n--];
      }
      else if(nums1[m] < nums2[n]) {
        nums1[index--] = nums2[n--];
      } else {
        nums1[index--] = nums1[m--];
      }
    }
  }

  @Test
  public void test1() throws Exception {
    long startTime = System.currentTimeMillis();

    int[] arr1 = {2,5,6,0,0,0};
    int[] arr2 = {1,1,1};
    merge(arr1,3, arr2, 3);

    long endTime = System.currentTimeMillis();
    long seconds = (endTime - startTime);
    System.out.println(seconds);
  }

}