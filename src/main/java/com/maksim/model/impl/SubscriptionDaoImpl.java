package com.maksim.model.impl;

import com.maksim.domain.Publication;
import com.maksim.domain.Subscription;
import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.SubscriptionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDAO {
    private final static SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();

    public SubscriptionDaoImpl() {
    }

    static SubscriptionDaoImpl getInstance() {
        return subscriptionDao;
    }

    public List<Subscription> findSubscriptionsByUser(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM subscriptions WHERE userId = ?");
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            List<Subscription> list =  resultToList(resultSet);

            for (int i = 0; i <list.size() ; i++) {
                System.out.println(list.get(i));
            }

            return list;
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public boolean addSubscription(Subscription subscription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection =  DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO subscriptions (publicationId, userId, isActive) VALUES (?,?,?)");
            preparedStatement.setInt(1, subscription.getPublication().getPublicationId());
            preparedStatement.setInt(2, subscription.getUser().getUserId());
            preparedStatement.setBoolean(3, true);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {

        } finally {
            DBConnection.close(connection, preparedStatement);
        }
        return false;
    }

    private List<Subscription> resultToList(ResultSet resultSet) throws SQLException {
        List<Subscription> list = new ArrayList<Subscription>();
        while (resultSet.next()) {
            Subscription subscription= createSubscriptionFromResult(resultSet);
            list.add(subscription);
        }
        return list;

    }

    private Subscription createSubscriptionFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int subscriptionId = resultSet.getInt(1);
        int publicationId = resultSet.getInt(2);
        int userId = resultSet.getInt(3);
        boolean isActive = resultSet.getBoolean(4);
        Publication publication = new PublicationDaoImpl().findById(publicationId);
        User user = new UserDaoImpl().findUserById(userId);
        return new Subscription(subscriptionId ,publication, user, isActive);
    }

}
