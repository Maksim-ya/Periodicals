package com.maksim.model.impl;

import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDAO {


    private final static UserDaoImpl userDao = new UserDaoImpl();

    public UserDaoImpl() {
    }

    static UserDaoImpl getInstance(){return userDao;}

    public boolean addUser(User user) {
        Connection dbConnection =  DBConnection.getConnection();

        try {
            PreparedStatement ps = dbConnection.prepareStatement(
                    "INSERT INTO users (login, password,fullName, address) VALUES (?,?,?,?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getAddress());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {

        } finally {

        }
        return false;
    }


    public void updateUser(User user) {

    }

    public void removeUser(int id) {

    }

    public User findByUserName(String UserName) {
        return null;
    }

    public List<User> findAllUsers() {
        return null;
    }
}