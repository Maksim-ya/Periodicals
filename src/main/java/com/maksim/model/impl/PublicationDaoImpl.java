package com.maksim.model.impl;

import com.maksim.domain.Publication;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.PublicationDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 09/Apr/18.
 */
public class PublicationDaoImpl implements PublicationDAO {

    private final static PublicationDaoImpl publicationDao = new PublicationDaoImpl();

    public PublicationDaoImpl() {
    }

    static PublicationDaoImpl getInstance() {
        return publicationDao;
    }


    @Override
    public List<Publication> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM publications");
            resultSet = statement.executeQuery();
            return resultToList(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    private List<Publication> resultToList(ResultSet resultSet) throws SQLException {
        List<Publication> list = new ArrayList<Publication>();
        while (resultSet.next()) {
            Publication subscription = createPeriodicalFromResult(resultSet);
            list.add(subscription);
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        return list;

    }

    private Publication createPeriodicalFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int publicationId = resultSet.getInt(1);
        String publicationTitle = resultSet.getString(2);
        BigDecimal publicationPrice = resultSet.getBigDecimal(3);
        String publicationType = resultSet.getString(4);
        int publicationEdition = resultSet.getInt(5);
        return new Publication(publicationId, publicationTitle, publicationPrice, publicationType, publicationEdition);
    }


    @Override
    public Publication findByName(String name) {
        return null;
    }

    @Override
    public boolean addPublication(Publication Publication) {
        return false;
    }
}
