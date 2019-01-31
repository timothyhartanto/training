package com.demo.training.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.training.entity.EntityMongo;

@Repository
public interface TrainingMongoRepository extends MongoRepository<EntityMongo, String> {
  EntityMongo findByName(String name);

  EntityMongo findByNumber(int number);
}
