package com.maksim.controller;

import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.impl.UserDaoImpl;

import java.sql.*;


public class LoginLogic {
    public static User checkLogin(String login, String password) {

        // defining the dao object
        UserDaoImpl dao = new UserDaoImpl();

        // getting the connection from DBUtils
        final Connection connection = DBConnection.getConnection();

        String sql_query = "SELECT USERID, FULLNAME, ADDRESS FROM USERS WHERE LOGIN = ? AND PASSWORD = ?";

        User user = null;
// проверка логина и пароля
        try {


            PreparedStatement statament = connection.prepareStatement(sql_query);

            statament.setString(1, login);
            statament.setString(2, password);

            // executing the query
            ResultSet rs = statament.executeQuery();
//            return rs.next();
            while(rs.next()) {

                // defining the UserDetails object
                user = new User();

                // setting the all attributes to object from database
                user.setUserId(rs.getInt("userId"));
//                user.setLogin(login);
                user.setFullName(rs.getString("fullName"));
                user.setAddress(rs.getString("address"));
                user.setValidUser(true);

            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return user;
    }
}
