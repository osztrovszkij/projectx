package service;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import entity.Order;
import entity.Service;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by roski on 21.5.16.
 */
public class OrderService {
    public static Order findById(String id) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Order> orderDao;
        try {
            orderDao = daoFactory.getOrderDao();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }

        try {
            List<Order> orders = orderDao.find(id);
            if (!orders.isEmpty()) {
                return orders.get(0);
            } else {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }
    }

    public static List<Order> findByLogin(String login) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Order> orderDao;
        try {
            orderDao = daoFactory.getOrderDao();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }

        try {
            List<Order> orders = orderDao.findAll();
            if (!orders.isEmpty()) {
                orders.removeIf(order -> {
                    if (!login.equals(order.getUser())) {
                        return true;
                    } else {
                        return false;
                    }
                });
                return orders;
            } else {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }
    }

    public static List<Order> findAll() throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Order> orderDao;
        try {
            orderDao = daoFactory.getOrderDao();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }

        try {
            return orderDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }
    }

    public static boolean addOrder(Order order) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Order> orderDao;
        try {
            orderDao = daoFactory.getOrderDao();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }

        Order s = null;
        try {
            List<Order> orders = orderDao.find(order.getId());
            if (!orders.isEmpty()) {
                s = orders.get(0);
            }

            if (s != null && s.getId().equals(order.getId())) {
                return false;
            }

            if (ServiceService.findByName(order.getService()) == null) {
                return false;
            }

            orderDao.persist(order);
            return true;
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }
    }

    public static boolean updateOrder(Order order) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Order> orderDao;
        try {
            orderDao = daoFactory.getOrderDao();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }

        Order s = null;
        try {
            List<Order> orders = orderDao.find(order.getId());
            if (!orders.isEmpty()) {
                s = orders.get(0);
            }
            if (s != null && s.getId().equals(order.getId())) {
                orderDao.update(order);
                return true;
            }
            return false;
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }
    }

    public static boolean deleteOrderById(String id) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Order> orderDao;
        try {
            orderDao = daoFactory.getOrderDao();
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }

        Order s = null;
        try {
            List<Order> orders = orderDao.find(id);
            if (!orders.isEmpty()) {
                s = orders.get(0);
            }
            if (s != null && s.getId().equals(id)) {
                orderDao.delete(id);
                return true;
            }
            return false;
        } catch (DaoException e) {
            throw new ServiceException("OrderService error" + e.getMessage());
        }
    }
}
