import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import static junit.framework.Assert.assertNotNull;

/**
 * Created by Tim Nedvetski on 20.05.2016.
 */
public class ServerConnection {
    private static final String url = "jdbc:mysql://localhost:3306/projectx?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";

    @Test
    public void TestServerConnection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(url, user, password);
        assertNotNull("NULL", connection);
    }

    @Test
    public void TestServerConnectionExeption() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(url, user, password);
        assertNotNull("NULL", connection);
    }
}
