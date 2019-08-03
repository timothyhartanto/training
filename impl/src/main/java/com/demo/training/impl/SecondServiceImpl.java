package com.demo.training.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.training.entity.SecondEntityPostgres;
import com.demo.training.repository.SecondPostgresRepository;
import com.gdn.training.api.SecondService;

@Service
public class SecondServiceImpl implements SecondService {

  @Autowired
  private SecondPostgresRepository secondPostgresRepository;

  @Override
  @Transactional
  public void saveSecondEntity(SecondEntityPostgres entityPostgres) throws Exception {
    entityPostgres.setNumber(entityPostgres.getNumber() + 1);

    secondPostgresRepository.save(entityPostgres);
  }
}
