package com.maksim.model.dao;

import com.maksim.domain.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;


public interface UserDAO {

    boolean addUser(User user);

    void updateUser(User user);
//    void updateUser(User user,Connection connection);

    void removeUser(int id);

    User findByUserName(String UserName);

    List<User> findAllUsers();

    User findUserById(int userId);
    User checkLoginAndPassword(String login, String password);
}
