package com.demo.training.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.training.entity.EntityMongo;
import com.demo.training.entity.EntityPostgres;
import com.demo.training.entity.SecondEntityPostgres;
import com.demo.training.repository.TrainingMongoRepository;
import com.demo.training.repository.TrainingPostgresRepository;
import com.gdn.training.api.SecondService;
import com.gdn.training.api.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {

  @Autowired
  private TrainingMongoRepository repository;

  @Autowired
  private TrainingPostgresRepository postgresRepository;

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  private SecondService secondService;

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

    EntityPostgres ep = postgresRepository.findByCharacter(character);
    ep.setNumberCharacter(ep.getNumberCharacter() + 1);

    return postgresRepository.findByCharacter(character);
  }


  @Override
  @Transactional(rollbackFor = Exception.class)
  public void insertPostgresEntity(EntityPostgres entity) throws Exception {
    postgresRepository.save(entity);
    SecondEntityPostgres secondEntityPostgres = new SecondEntityPostgres();
    secondEntityPostgres.setText(entity.getCharacter());
    secondEntityPostgres.setNumber(entity.getNumberCharacter());

    for (int i = 0; i < 200; i++) {
      Runnable runnable = new Runnable() {
        @Override
        public void run() {

          try {
            secondService.saveSecondEntity(secondEntityPostgres);
          } catch (Exception e) {
            e.printStackTrace();
          }

        }
      };
      Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
          try {
            secondService.saveSecondEntity(secondEntityPostgres);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      };
      new Thread(runnable).start();
      new Thread(runnable2).start();
    }
  }

  String kafkaTopic = "hahaha";

  @Override
  public void send(String message) {
    kafkaTemplate.send(kafkaTopic, message);
  }
}
