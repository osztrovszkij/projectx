package dao.mysqlimpl;

import dao.AbstractJdbcDao;
import dao.DaoException;
import dao.factoryimpl.MysqlDaoFactory;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roski on 4/22/16.
 */
public final class MysqlUserDao extends AbstractJdbcDao<User, Integer>{
    //private final static MysqlUserDao instance = new MysqlUserDao();

    public MysqlUserDao() throws DaoException {
        super(MysqlDaoFactory.createConnection());
    }

//    public static MysqlUserDao getInstance() {
//        return instance;
//    }

    @Override
    public String getSelectQuery() {
        return UserSqlStatement.SELECT_QUERY;
    }

    @Override
    public String getFindQuery() {
        String rawQuery = getSelectQuery();
        return rawQuery.substring(0, rawQuery.length() - 1) + " WHERE login = ?;";
    }

    @Override
    public String getCreateQuery() {
        return UserSqlStatement.INSERT_QUERY;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE projectx.clients \n" +
                "SET name = ?, surname  = ?, enrolment_date = ?, group_id = ? \n" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM projectx.clients WHERE id= ?;";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws DaoException {
        List<User> users = new ArrayList<>();

        try {
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setGroup(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }


    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws DaoException {
        
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws DaoException {

    }

    @Override
    public User create() throws DaoException {
        return null;
    }
}
