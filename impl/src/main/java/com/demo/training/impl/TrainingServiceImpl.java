package com.demo.training.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.training.entity.EntityMongo;
import com.demo.training.entity.EntityPostgres;
import com.demo.training.repository.TrainingMongoRepository;
import com.demo.training.repository.TrainingPostgresRepository;
import com.gdn.training.api.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {

  @Autowired
  private TrainingMongoRepository repository;

  @Autowired
  private TrainingPostgresRepository postgresRepository;

  @Override
  @Cacheable(value = "entity-redis", key = "#number")
  public EntityMongo findEntity(int number) {
    return repository.findByNumber(number);
  }

  @Override
  public void insertEntity(EntityMongo entity) {
    repository.save(entity);
  }

  @Override
  public void simpleMethod() {
    System.out.println("This is executed from the service impl");
  }

  @Override
  public EntityPostgres findPostgresEntity(String character) {
    return postgresRepository.findByCharacter(character);
  }
}
