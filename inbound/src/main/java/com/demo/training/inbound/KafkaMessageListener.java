package com.demo.training.inbound;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.training.config.BeanMapper;

@Service
public class KafkaMessageListener {

  @KafkaListener(topics = "topic.kafka.training", groupId = "groupId.kafka.training")
  public void kafkaListener(String record) {
//    BeanMapper.map(record, .class)
    System.out.println(record);
  }
}
