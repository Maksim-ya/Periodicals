package com.maksim.model.impl;

import com.maksim.model.dao.DaoFactory;
import com.maksim.model.dao.PublicationDAO;
import com.maksim.model.dao.SubscriptionDAO;
import com.maksim.model.dao.UserDAO;


public class DaoFactoryImpl implements DaoFactory {
    private static final DaoFactoryImpl FACTORY = new DaoFactoryImpl();

    private DaoFactoryImpl(){}

    public static DaoFactoryImpl getInstance() {
        return FACTORY;
    }
    @Override
    public UserDAO getUserDao() {
        return UserDaoImpl.getInstance();
    }

    @Override
    public PublicationDAO getPublicationDao() {
        return PublicationDaoImpl.getInstance();
    }

    @Override
    public SubscriptionDAO getSubcriptionDao() {
        return SubscriptionDaoImpl.getInstance();
    }

}
