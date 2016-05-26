package dao.mysqlimpl;

import dao.AbstractJdbcDao;
import dao.DaoException;
import dao.factoryimpl.MysqlDaoFactory;
import dao.mysqlimpl.sqlstatement.OrderSqlStatement;
import entity.Order;
import entity.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roski on 21.5.16.
 */
public class MysqlOrderDao extends AbstractJdbcDao<Order> {
    public MysqlOrderDao() throws DaoException {
        super(MysqlDaoFactory.createConnection());
    }

    @Override
    public String getInsertQuery() {
        return OrderSqlStatement.INSERT_QUERY;
    }

    @Override
    public String getSelectQuery() {
        return OrderSqlStatement.SELECT_QUERY;
    }

    @Override
    public String getFindQuery() {
        String rawQuery = getSelectQuery();
        return rawQuery.substring(0, rawQuery.length() - 1) + " WHERE id_order = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return OrderSqlStatement.UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return OrderSqlStatement.DELETE_QUERY;
    }

    @Override
    public String getLastRowQuery() {
        String rawQuery = getSelectQuery();
        return rawQuery.substring(0, rawQuery.length() - 1) + " WHERE id_order = last_insert_id();";
    }

    @Override
    protected List<Order> parseResultSet(ResultSet rs) throws DaoException {
        List<Order> orders = new ArrayList<>();

        try {
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getString("id_order"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setEventDate(rs.getDate("event_date"));
                order.setService(rs.getString("name"));
                order.setUser(rs.getString("login"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return orders;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Order object) throws DaoException, SQLException {
        statement.setDate(1, object.getEventDate());
        statement.setString(2, object.getService());
        statement.setString(3, object.getUser());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) throws DaoException, SQLException {
        statement.setDate(1, object.getOrderDate());
        statement.setDate(2, object.getEventDate());
        statement.setString(3,object.getService());
        statement.setString(4, object.getUser());
        statement.setString(5, object.getId());
    }

    @Override
    public Order create() throws DaoException {
        return null;
    }
}
