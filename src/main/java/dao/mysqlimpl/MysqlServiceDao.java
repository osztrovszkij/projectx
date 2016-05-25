package dao.mysqlimpl;

import dao.AbstractJdbcDao;
import dao.DaoException;
import dao.factoryimpl.MysqlDaoFactory;
import dao.mysqlimpl.sqlstatement.ServiceSqlStatement;
import entity.Service;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roski on 20.5.16.
 */
public class MysqlServiceDao extends AbstractJdbcDao<Service> {
    public MysqlServiceDao() throws DaoException {
        super(MysqlDaoFactory.createConnection());
    }

    @Override
    public String getInsertQuery() {
        return ServiceSqlStatement.INSERT_QUERY;
    }

    @Override
    public String getSelectQuery() {
        return ServiceSqlStatement.SELECT_QUERY;
    }

    @Override
    public String getFindQuery() {
        String rawQuery = getSelectQuery();
        return rawQuery.substring(0, rawQuery.length() - 1) + " WHERE name = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return ServiceSqlStatement.UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return ServiceSqlStatement.DELETE_QUERY;
    }

    @Override
    public String getLastRowQuery() {
        String rawQuery = getSelectQuery();
        return rawQuery.substring(0, rawQuery.length() - 1) + " WHERE id_service = last_insert_id();";
    }

    @Override
    protected List<Service> parseResultSet(ResultSet rs) throws DaoException {
        List<Service> services = new ArrayList<>();

        try {
            while (rs.next()) {
                Service service = new Service();
                service.setName(rs.getString("name"));
                service.setDescription(rs.getString("description"));
                services.add(service);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return services;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Service object) throws DaoException, SQLException {
        statement.setString(1, object.getName());
        statement.setString(2, object.getDescription());
        statement.setInt(3, 1);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Service object) throws DaoException, SQLException {
        statement.setString(1, object.getDescription());
        statement.setInt(2, 1);
        statement.setString(3, object.getName());
    }

    @Override
    public Service create() throws DaoException {
        return null;
    }
}
