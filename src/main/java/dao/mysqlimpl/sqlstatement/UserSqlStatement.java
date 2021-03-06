package dao.mysqlimpl.sqlstatement;

/**
 * Created by roski on 20.5.16.
 */
public class UserSqlStatement {
    public final static String SELECT_QUERY = "SELECT login, password, roles.role FROM projectx.users JOIN projectx.roles ON roles.id_roles = users.roles_id_roles;";
    public final static String INSERT_QUERY = "INSERT INTO projectx.users " +
            "(login, password, roles_id_roles) VALUES (?, ?, ?);";
    public final static String DELETE_QUERY = "DELETE FROM projectx.users WHERE login = ?;";
    public final static String UPDATE_QUERY = "UPDATE projectx.users SET " +
            "password = ?, roles_id_roles = ? WHERE login = ?";
}
