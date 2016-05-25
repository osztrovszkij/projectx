package dao.mysqlimpl.sqlstatement;

/**
 * Created by roski on 21.5.16.
 */
public class OrderSqlStatement {
    public final static String SELECT_QUERY = "SELECT id_order, order_date, event_date, name, login FROM projectx.orders " +
            "JOIN projectx.services ON services.id_service = orders.services_id_service JOIN projectx.users ON orders.users_id_user = users.id_user;";
    public final static String INSERT_QUERY = "INSERT INTO projectx.orders (order_date, event_date, services_id_service, users_id_user)" +
            " VALUES (CURDATE(), ?," +
            " (SELECT id_service FROM projectx.services WHERE name = ?)," +
            " (SELECT id_user FROM projectx.users WHERE login = ?));";
    public final static String DELETE_QUERY = "DELETE FROM projectx.orders WHERE id_order = ?;";
    public final static String UPDATE_QUERY = "UPDATE projectx.orders SET " +
            "order_date = ?, " +
            "event_date = ?, " +
            "services_id_service = (SELECT id_service FROM projectx.services WHERE name = ?), " +
            "users_id_user = (SELECT id_user FROM projectx.users WHERE login = ?) " +
            "WHERE id_order = ?;";
}
