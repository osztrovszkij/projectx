import dao.DaoException;
import org.junit.Before;
import org.junit.Test;
import service.ServiceException;
import service.ServiceService;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import entity.Service;

/**
 * Created by Tim Nedvetski on 21.05.2016.
 */
public class ServiceOperationTest {
    Service service;
    @Before
    public void Init() {
        service = new Service();
    }

    @Test (expected = ServiceException.class)
    public void TestAddServiceException() throws ServiceException {
        assertTrue(ServiceService.addService(service));
    }
}
