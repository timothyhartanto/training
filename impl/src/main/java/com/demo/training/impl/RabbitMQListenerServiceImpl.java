package com.demo.training.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListenerServiceImpl {

  @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
  public void receivedMessage(Object model) {
    try{
      System.out.println("message received : " + model.toString());
    } catch (Exception e) {
      System.out.println("exception : " + e);
    }

  }
}
