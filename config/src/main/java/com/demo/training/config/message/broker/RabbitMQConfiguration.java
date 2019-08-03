package com.demo.training.config.message.broker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

  @Value("${training.rabbitmq.queue}")
  String queueName;

  @Value("${training.rabbitmq.exchange}")
  String exchange;

  @Value("${training.rabbitmq.routingkey}")
  private String routingkey;

  @Bean
  Queue queue() {
    return new Queue(queueName, false);
  }

  @Bean
  DirectExchange exchange() {
    return new DirectExchange(exchange);
  }

  @Bean
  Binding binding(Queue queue, DirectExchange exchange) {
    return BindingBuilder.bind(queue)
        .to(exchange)
        .with(routingkey);
  }
}
