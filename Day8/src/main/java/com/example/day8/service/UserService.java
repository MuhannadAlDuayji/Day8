package com.example.day8.service;

import com.example.day8.model.User;
import com.example.day8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user){

        User oldUser=userRepository.getById(id);

        if(oldUser==null)
            return false;

        userRepository.save(oldUser);

        return true;
    }
    public boolean deleteUser(Integer id){

        User user = userRepository.getById(id);

        if(user==null)
            return false;


        userRepository.delete(user);
        return true;
    }








}
