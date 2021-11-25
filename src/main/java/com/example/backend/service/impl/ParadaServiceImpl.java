package com.example.backend.service.impl;

import com.example.backend.model.Rotas;
import com.example.backend.model.Users;
import com.example.backend.repository.ParadaRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.ParadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class ParadaServiceImpl implements ParadaService {

    @Autowired
    private ParadaRepository paradaRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String salvarParada(Rotas rota) {
        Users refUser =
               userRepository.findByIdVeiculo(rota.getUser().getIdVeiculo());
        rota.setUser(refUser);
        paradaRepository.save(rota);
        return rota.getId();
    }

   @Override
    public Rotas getRota(String routId) {
        return paradaRepository.findById(routId).orElseGet(Rotas::new);
    }
}
