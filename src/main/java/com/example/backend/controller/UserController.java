package com.example.backend.controller;

import com.example.backend.model.Users;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    //private final PasswordEncoder enconder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/users")
    public Users createUser(@RequestBody Users usuario){
        return userService.createUser(usuario);
    }

    @PostMapping("/login/{id}")
    public ResponseEntity<String> getUser(@PathVariable("id") String id, @RequestBody Users password) {
        Users request = userService.getUser(id);
        if (!(request.getCodigo().equals("")) && request.getPassword().equals(password.getPassword())) {
            return new ResponseEntity<String>(id, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("User not exists", HttpStatus.BAD_REQUEST);
        }
    }

}
