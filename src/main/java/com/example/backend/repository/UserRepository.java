package com.example.backend.repository;

import com.example.backend.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<Users, String> {

    Users findByIdVeiculo(String idVeiculo);
}