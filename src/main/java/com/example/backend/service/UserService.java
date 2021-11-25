package com.example.backend.service;

import com.example.backend.model.Users;

import java.util.List;

public interface UserService {

    Users createUser(Users user);
    Users getUser(String idVeiculo);
    List<Users> getUsers();

}
