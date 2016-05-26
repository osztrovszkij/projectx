import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Tim Nedvetski on 20.05.2016.
 */
public class User {
    String password;
    String login;
    String role;
    entity.User user;

    @Before
    public void Init() {
        role = "user";
        login = "bimsa";
        password = "1234";
        user = new entity.User();
    }

    @Test
    public void TestLogin() {
        user.setLogin(login);
        assertEquals("Login", login, user.getLogin());
    }

    @Test
    public void RolePassword(){
        user.setRole(role);
        assertEquals("Role", role, user.getRole());
    }

    @Test
    public void TestPassword(){
        user.setPassword(password);
        assertEquals("Password", password, user.getPassword());
    }

    @After
    public void Clear() {
        role = null;
        login = null;
        password = null;
        user = null;
    }
}
