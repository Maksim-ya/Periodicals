package com.maksim.model.dao;

import com.maksim.domain.User;

import java.util.List;


public interface UserDAO {

    boolean addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User findByUserName(String UserName);

    List<User> findAllUsers();
}
