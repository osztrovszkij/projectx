package dao.mysqlimpl.sqlstatement;

/**
 * Created by roski on 20.5.16.
 */
public class ServiceSqlStatement {
    public final static String SELECT_QUERY = "SELECT name, description FROM projectx.services;";
    public final static String INSERT_QUERY = "INSERT INTO projectx.services (name, description, categories_id_category) VALUES (?, ?, ?);";
    public final static String DELETE_QUERY = "DELETE FROM projectx.services WHERE name = ?;";
    public final static String UPDATE_QUERY = "UPDATE projectx.services SET description = ?, categories_id_category = ?  WHERE name = ?";
}
