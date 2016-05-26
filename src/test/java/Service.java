import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.*;

import javax.xml.ws.soap.Addressing;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Tim Nedvetski on 21.05.2016.
 */
public class Service {
    private String name;
    private String description;
    entity.Service service = null;


    @Before
    public void Init() {
        name = "KFC";
        description = "chiken";
        service = new entity.Service();
    }

    @Test
    public void TestLogin() {
        service.setName(name);
        assertEquals("Service name", name, service.getName());
    }

    @Test
    public void RolePassword(){
        service.setDescription(description);
        assertEquals("Service description", description, service.getDescription());
    }

    @After
    public void clear() {
        name = null;
        description = null;
        service = null;
    }

}
