package com.maksim.model.impl;

import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDAO {


    private final static UserDaoImpl userDao = new UserDaoImpl();

    public UserDaoImpl() {
    }

    static UserDaoImpl getInstance(){return userDao;}

    public boolean addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
           connection =  DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (login, password,fullName, address) VALUES (?,?,?,?)");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {

        } finally {
            DBConnection.close(connection, preparedStatement);
        }
        return false;
    }

    @Override
    public User findUserById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE userId = ?");
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            return createUserFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    private User createUserFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int userId = resultSet.getInt(1);
        String login = resultSet.getString(2);
        String password = resultSet.getString(3);
        String fullName = resultSet.getString(4);
        String address = resultSet.getString(5);
        String role = resultSet.getString(6);
        return new User(userId, login,password,fullName,address,role);
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