package com.example.backend.service.impl;

import com.example.backend.model.Users;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUser(String idVeiculo) {
        return userRepository.findByIdVeiculo(idVeiculo);
    }

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}
