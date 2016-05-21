package service;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import entity.User;

import java.util.List;

/**
 * Created by roski on 4/22/16.
 */
public class UserService {
    public static User findByLogin(String login) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User> userDao;
        try {
            userDao = daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

        try {
            List<User> users = userDao.find(login);
            if (!users.isEmpty()) {
                return userDao.find(login).get(0);
            } else {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static List<User> findAll() throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User> userDao;
        try {
            userDao = daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }

        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }
    }
}
