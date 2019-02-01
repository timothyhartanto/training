package com.demo.training.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.training.model.TestModel;

@Service
public class RabbitMQServiceImpl {
  @Autowired
  private AmqpTemplate rabbitTemplate;

  @Value("${javainuse.rabbitmq.exchange}")
  private String exchange;

  @Value("${javainuse.rabbitmq.routingkey}")
  private String routingkey;

  public void send(TestModel model) {
    rabbitTemplate.convertAndSend(exchange, routingkey, model);
    System.out.println("Send msg = " + model);
  }
}
