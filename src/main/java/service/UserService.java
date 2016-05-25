package service;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import entity.Service;
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
                return users.get(0);
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

    public static boolean addUser(User user) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User> userDao;
        try {
            userDao = daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }

        User s = null;
        try {
            List<User> services = userDao.find(user.getLogin());
            if (!services.isEmpty()) {
                s = userDao.find(user.getLogin()).get(0);
            }

            if (s != null && s.getLogin().equals(user.getLogin())) {
                return false;
            }
            userDao.persist(user);
            return true;
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }
    }

    public static boolean updateUser(User user) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User> userDao;
        try {
            userDao = daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }

        User s = null;
        try {
            List<User> users = userDao.find(user.getLogin());
            if (!users.isEmpty()) {
                s = users.get(0);
            }
            if (s != null && s.getLogin().equals(user.getLogin())) {
                userDao.update(user);
                return true;
            }
            return false;
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }
    }

    public static boolean deleteUserByLogin(String login) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<User> userDao;
        try {
            userDao = daoFactory.getUserDao();
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }

        User s = null;
        try {
            List<User> services = userDao.find(login);
            if (!services.isEmpty()) {
                s = services.get(0);
            }
            if (s != null && s.getLogin().equals(login)) {
                userDao.delete(login);
                return true;
            }
            return false;
        } catch (DaoException e) {
            throw new ServiceException("UserService error", e);
        }
    }
}
