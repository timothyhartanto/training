package com.demo.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.training.config.BeanMapper;
import com.demo.training.entity.EntityMongo;
import com.demo.training.entity.EntityPostgres;
import com.demo.training.impl.RabbitMQServiceImpl;
import com.demo.training.model.PostgresEntityRequest;
import com.demo.training.model.TestModel;
import com.gdn.training.api.TrainingService;

@RequestMapping("/api")
@RestController
@EnableCaching
public class Controller {

  @Autowired
  private TrainingService trainingService;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private RabbitMQServiceImpl rabbitMQService;

  @GetMapping("/getEntity")
  public String getEntity(@RequestParam int number){
    trainingService.simpleMethod();
    return trainingService.findEntity(number).toString();
  }

  @GetMapping("/getPostgresEntity")
  public String getPostgresEntity(@RequestParam String character){
    return trainingService.findPostgresEntity(character).toString();
  }

  @PutMapping("/insertEntity")
  public void insertNewEntity(@RequestBody TestModel testModel) {
    EntityMongo entityMongo = new EntityMongo();
    entityMongo.setNumber(testModel.getNumber());
    entityMongo.setName(testModel.getName());
    trainingService.insertEntity(entityMongo);
  }

  @PutMapping("/insertPostgresEntity")
  public void insertNewPostgresEntity(@RequestBody PostgresEntityRequest request) throws Exception{
    EntityPostgres entityPostgres = BeanMapper.map(request, EntityPostgres.class);
//    try {
      trainingService.insertPostgresEntity(entityPostgres);
//    } catch (Exception e) {
//
//    }
  }

  @GetMapping("/sendMessageMQ")
  public void sendMessageToMQ(@RequestParam String name, @RequestParam int number){
    TestModel model = TestModel.builder()
        .name(name)
        .number(number)
        .build();
    rabbitMQService.send(model);
  }

  @GetMapping("/sendMessageKafka")
  public void sendMessageToKafka(@RequestParam String text){
    trainingService.send(text);
  }
}
