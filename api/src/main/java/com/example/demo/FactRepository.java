package com.example.demo;

import org.springframework.data.repository.CrudRepository;


public interface FactRepository extends CrudRepository<Fact, Integer> {
}