package com.gdn.training.api;

import com.demo.training.entity.EntityMongo;
import com.demo.training.entity.EntityPostgres;

public interface TrainingService {
  EntityMongo findEntity(int number);

  EntityPostgres findPostgresEntity(String character);

  void insertEntity(EntityMongo entity);

  void send(String message);

  void simpleMethod();
}
