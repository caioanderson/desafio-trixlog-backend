package com.example.backend.repository;

import com.example.backend.model.Rotas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParadaRepository extends MongoRepository<Rotas, String> {

}
