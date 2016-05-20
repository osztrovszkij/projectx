package dao.mysqlimpl;

/**
 * Created by roski on 20.5.16.
 */
public class UserSqlStatement {
    final static String SELECT_QUERY = "SELECT login, password, roles.role FROM projectx.users JOIN projectx.roles ON roles.id_roles = users.roles_id_roles;";
    final static String INSERT_QUERY = "INSERT INTO projectx.clients () VALUES (?, ?, ?, ?);";
}
