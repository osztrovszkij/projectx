package dao.mysqlimpl.sqlstatement;

/**
 * Created by roski on 20.5.16.
 */
public class UserSqlStatement {
    public final static String SELECT_QUERY = "SELECT login, password, roles.role FROM projectx.users JOIN projectx.roles ON roles.id_roles = users.roles_id_roles;";
    public final static String INSERT_QUERY = "";
    public final static String DELETE_QUERY = "";
    public final static String UPDATE_QUERY = "";
}
