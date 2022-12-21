package com.example.day8.controller;


import com.example.day8.model.User;
import com.example.day8.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class UserController {
    @Autowired
    private final UserService userservice;

    @GetMapping("/get")
    public ResponseEntity getUser(){

        List<User> blogs= userservice.getUser();
        return ResponseEntity.status(HttpStatus.OK).body(blogs);

    }
    @PostMapping("/add")
    public ResponseEntity addUser(User user,  Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body (message);
        }
        userservice.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body (("User added"));
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@PathVariable @Valid Integer id, User user, Errors errors){
        if (errors.hasErrors()){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body (errors.getFieldError().getDefaultMessage());
        }
        userservice.updateUser(id,user);

        return ResponseEntity.status(HttpStatus.OK).body(("User updated"));

    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@PathVariable @Valid Integer id){
        userservice.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(("User deleted"));
    }

}