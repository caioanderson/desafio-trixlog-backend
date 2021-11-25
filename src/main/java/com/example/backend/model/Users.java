package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {

    @Id
    private String codigo;

    @Indexed(unique=true)
    private String idVeiculo;

    private String password;

    public Users(){}

    public Users(String codigo, String password) {
        this.codigo = codigo;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setcCdigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + codigo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
