package com.webapp6.service;

import com.webapp6.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getOne(String email);
    void add(User user);
}
