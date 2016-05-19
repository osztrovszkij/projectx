package dao.factoryimpl;

import dao.DaoException;
import dao.DaoFactory;
import dao.GenericDao;
import dao.mysqlimpl.MysqlUserDao;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by roski on 4/22/16.
 */
public final class MysqlDaoFactory extends DaoFactory {
    private final static MysqlDaoFactory instance = new MysqlDaoFactory();

    private static final String url = "jdbc:mysql://localhost:3306/projectx?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.jdbc.Driver";

    private MysqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final static MysqlDaoFactory getInstance() {
        return instance;
    }

    public static Connection createConnection() throws DaoException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return  connection;
    }

    public GenericDao<User, Integer> getUserDao() throws DaoException {
        return new MysqlUserDao();
    }
}
