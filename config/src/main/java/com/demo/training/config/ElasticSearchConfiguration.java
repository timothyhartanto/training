package com.demo.training.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class ElasticSearchConfiguration {
  @Value("${elasticsearch.host:localhost}")
  public String host;
  @Value("${elasticsearch.port:9300}")
  public int port;
}
