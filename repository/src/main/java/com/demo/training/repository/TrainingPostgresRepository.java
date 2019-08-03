package com.demo.training.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.training.entity.EntityPostgres;

@Repository
public interface TrainingPostgresRepository extends JpaRepository<EntityPostgres, String> {

//  @Lock(LockModeType.PESSIMISTIC_READ)
  @Lock(LockModeType.OPTIMISTIC)
  EntityPostgres findByCharacter(String character);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
//  EntityPostgres save(EntityPostgres entityPostgres);
}
