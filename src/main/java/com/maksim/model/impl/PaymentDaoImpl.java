package com.maksim.model.impl;

import com.maksim.domain.Payment;
import com.maksim.domain.Publication;
import com.maksim.domain.Subscription;
import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.PaymentDAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.List;


/**
 * Created by Максим on 30/Apr/18.
 */
public class PaymentDaoImpl implements PaymentDAO {
    @Override
    public boolean addPayment(Payment payment, User user, List<Publication> publicationList) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection =  DBConnection.getConnection();
//            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO payments (userId, totalPrice, dateTime) VALUES (?,?,?)");
            int userId = user.getUserId();
            preparedStatement.setInt(1, userId);
            BigDecimal totalPrice = payment.getTotalPrice();
            preparedStatement.setBigDecimal(2, totalPrice);
            Date date = new Date();
            Timestamp dateTime =new Timestamp(date.getTime());
            preparedStatement.setTimestamp(3, dateTime);
            preparedStatement.executeUpdate();


            for (int i = 0; i <publicationList.size() ; i++) {
                Subscription subscription = new Subscription();
                subscription.setPublication(publicationList.get(i));
                subscription.setUser(user);
                subscription.setPayment(new PaymentDaoImpl().findPaymentIdByPayment(userId,totalPrice));
                new SubscriptionDaoImpl().addSubscription(subscription);
            }


            BigDecimal priceUpdate = user.getAccount().subtract(payment.getTotalPrice());
            user.setAccount(priceUpdate);
            new UserDaoImpl().updateUser(user);
//            connection.commit();
            return true;
        } catch (SQLException e) {
//            connection.rollback();

        } finally {
            DBConnection.close(connection, preparedStatement);
        }
        return false;
    }

    @Override
    public Payment findPaymentById(int paymentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PAYMENTS WHERE PAYMENTID = ?");
            preparedStatement.setInt(1, paymentId);
            resultSet = preparedStatement.executeQuery();
            return createPaymentFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    public Payment findPaymentIdByPayment(int userId, BigDecimal totalPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PAYMENTS WHERE USERID = ? AND TOTALPRICE=? ");
            preparedStatement.setInt(1,userId);
            preparedStatement.setBigDecimal(2,totalPrice);
//            preparedStatement.setTimestamp(3,dateTime);
            resultSet = preparedStatement.executeQuery();
            return createPaymentFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    private Payment createPaymentFromResult(ResultSet resultSet)throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int paymentId = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        User user  = new UserDaoImpl().findUserById(userId);
        BigDecimal totalPrice =resultSet.getBigDecimal(3);
        Timestamp dateTime = resultSet.getTimestamp(4);
        Payment payment = new Payment(paymentId,user,totalPrice,dateTime);
//        System.out.println(payment);
        return payment ;
    }

}
