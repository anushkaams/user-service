package com.example.userservice.service;

import java.util.List;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
