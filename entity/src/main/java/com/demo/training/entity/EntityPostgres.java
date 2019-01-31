package com.demo.training.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="table_postgres")
public class EntityPostgres implements Serializable {

  private static final long serialVersionUID = 6398134179276980058L;

  @Id
  private String id;

  private String character;

  private int numberCharacter;
}
