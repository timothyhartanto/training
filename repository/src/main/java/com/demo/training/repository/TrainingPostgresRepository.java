package com.demo.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.training.entity.EntityPostgres;

@Repository
public interface TrainingPostgresRepository extends JpaRepository<EntityPostgres, String> {

  EntityPostgres findByCharacter(String character);
}
