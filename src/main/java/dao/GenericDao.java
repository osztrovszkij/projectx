package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by roski on 4/23/16.
 */
public interface GenericDao<T> {
    public T create() throws DaoException;
    public T persist(T object)  throws DaoException;
    public List<T> find(Object key) throws DaoException;
    public void update(T object) throws DaoException;
    public void delete(Object object) throws DaoException;
    public List<T> findAll() throws DaoException;
}
