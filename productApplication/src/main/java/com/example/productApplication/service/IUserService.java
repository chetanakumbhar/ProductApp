package com.example.productApplication.service;

import com.example.productApplication.domain.User;

import java.util.List;

public interface IUserService {
    public User addUser(User user);
    public User getUser(String email);
    public List<User> getAllUserByAdmin();
}
