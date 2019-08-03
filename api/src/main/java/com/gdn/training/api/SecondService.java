package com.gdn.training.api;

import com.demo.training.entity.SecondEntityPostgres;

public interface SecondService {
  void saveSecondEntity(SecondEntityPostgres entityPostgres) throws Exception;
}
