package com.demo.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.training.entity.SecondEntityPostgres;

@Repository
public interface SecondPostgresRepository extends JpaRepository<SecondEntityPostgres, String> {

}
