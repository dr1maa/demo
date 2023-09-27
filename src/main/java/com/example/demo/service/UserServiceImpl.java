package com.example.demo.service;

import com.example.demo.model.Enum.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(User userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Пользователь с таким Email уже существует");
        }
        if (userRepository.findByUsername(user.getName()) != null) {
            return null;
        }
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setRole(roles);
        String password = "1111";
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public User getUserInfo(User user) {
        User thisUser = userRepository.findByUserId(user);
        if (user == null) {
            return null;
        }
        String username = user.getName();
        String email = user.getEmail();
        Set<Role> roles = user.getRole();
        return thisUser;
    }

    @Override
    public User updateUser(User user, User updatedUser) {
        User thisUser = userRepository.findByUserId(user);
        thisUser.setUserName(updatedUser.getUserName());
        thisUser.setName(updatedUser.getName());
        return userRepository.save(thisUser);
    }

    @Override
    public void deleteUser(User user) {
        User thisUser = userRepository.findByUserId(user);
        if (thisUser == null) {
            throw new RuntimeException("Пользователь не существует");
        }
        userRepository.deleteById(user.getUserId());
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
