package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User getUserById(User userId);

    User register(User user);

    User getUserInfo(User user);

    User updateUser(User user, User updatedUser);

    void deleteUser(User user);
    User getUserByUsername(String username);

}
