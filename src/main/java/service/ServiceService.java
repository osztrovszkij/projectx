package service;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import entity.Service;
import entity.User;

import java.util.List;

/**
 * Created by roski on 20.5.16.
 */
public class ServiceService {
        public static Service findByName(String name) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Service> serviceDao;
        try {
            serviceDao = daoFactory.getServiceDao();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

        try {
            List<Service> services = serviceDao.find(name);
            if (!services.isEmpty()) {
                return services.get(0);
            } else {
                return null;
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static List<Service> findAll() throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Service> serviceDao;
        try {
            serviceDao = daoFactory.getServiceDao();
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }

        try {
            return serviceDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }
    }

    public static boolean addService(Service service) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Service> serviceDao;
        try {
            serviceDao = daoFactory.getServiceDao();
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }

        Service s = null;
        try {
            List<Service> services = serviceDao.find(service.getName());
            if (!services.isEmpty()) {
                s = serviceDao.find(service.getName()).get(0);
            }

            if (s != null && s.getName().equals(service.getName())) {
                return false;
            }
            serviceDao.persist(service);
            return true;
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }
    }

    public static boolean updateService(Service service) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Service> serviceDao;
        try {
            serviceDao = daoFactory.getServiceDao();
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }

        Service s = null;
        try {
            List<Service> services = serviceDao.find(service.getName());
            if (!services.isEmpty()) {
                s = services.get(0);
            }
            if (s != null && s.getName().equals(service.getName())) {
                serviceDao.update(service);
                return true;
            }
            return false;
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }
    }

    public static boolean deleteServiceByName(String name) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        GenericDao<Service> serviceDao;
        try {
            serviceDao = daoFactory.getServiceDao();
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }

        Service s = null;
        try {
            List<Service> services = serviceDao.find(name);
            if (!services.isEmpty()) {
                s = services.get(0);
            }
            if (s != null && s.getName().equals(name)) {
                serviceDao.delete(name);
                return true;
            }
            return false;
        } catch (DaoException e) {
            throw new ServiceException("ServiceService error", e);
        }
    }
}
