package com.example.backend.service;

import com.example.backend.model.Rotas;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ParadaService {

    String salvarParada(Rotas rota);

    Rotas getRota(String date);
}
