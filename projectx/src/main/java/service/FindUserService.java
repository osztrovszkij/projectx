package service;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import entity.User;

import java.util.List;

/**
 * Created by roski on 4/22/16.
 */
public class FindUserService {
    public static User findByUsername(String username) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User, Integer> userDao = null;
        try {
            userDao = (GenericDao<User, Integer>) daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

        try {
            List<User> users = userDao.find(username);
            if (!users.isEmpty()) {
                return userDao.find(username).get(0);
            } else {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static List<User> findAll() throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User, Integer> userDao = null;
        try {
            userDao = (GenericDao<User, Integer>) daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException("FindUserService error", e);
        }

        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("FindUserService error", e);
        }
    }
}
