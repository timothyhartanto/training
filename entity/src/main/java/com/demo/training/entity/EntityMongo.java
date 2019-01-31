package com.demo.training.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "entity_mongo")
public class EntityMongo implements Serializable {
  private static final long serialVersionUID = -1627356737144624765L;

  private String name;
  private int number;
}
