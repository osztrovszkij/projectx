package dao;

import dao.factoryimpl.MysqlDaoFactory;
import entity.Service;
import entity.User;

/**
 * Created by roski on 4/22/16.
 */
public abstract class DaoFactory {
    public static final int MYSQL = 1;

    public abstract GenericDao<User> getUserDao() throws DaoException;
    public abstract GenericDao<Service> getServiceDao() throws DaoException;

    public static DaoFactory getDaoFactory(int factoryType) {
        switch (factoryType) {
            case MYSQL:
                return MysqlDaoFactory.getInstance();
            default:
                return null;
        }
    }
}
