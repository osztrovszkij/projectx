import entity.*;
import org.junit.Test;
import service.ServiceService;
import service.ServiceException;
import service.UserService;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;

/**
 * Created by Tim Nedvetski on 20.05.2016.
 */
public class LoginController {
    entity.User user = null;

    @Test
    public void TestFind() throws ServiceException {
        user = UserService.findByLogin("bimsa");
        assertNotNull("NULL", user);
    }
    @Test
    public void TestNotFind() throws ServiceException {
        user = UserService.findByLogin("not_user");
        assertNull("NULL", user);
    }

    @Test
    public void TestFindException () throws ServiceException {
        try{
            user = UserService.findByLogin("bimsa");
        }catch (ServiceException e){
            fail("Can't connect or can't load data from server!");
        }

    }

}
