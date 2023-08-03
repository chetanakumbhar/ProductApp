package com.example.productApplication.service;

import com.example.productApplication.domain.User;
import com.example.productApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findById(email).get();
    }

    @Override
    public List<User> getAllUserByAdmin() {
        return userRepository.findAll();
    }
}
