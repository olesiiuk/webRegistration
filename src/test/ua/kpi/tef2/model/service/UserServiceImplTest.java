package ua.kpi.tef2.model.service;

import org.junit.Test;
import ua.kpi.tef2.model.exceptions.UserAlreadyExistsException;

import static junit.framework.TestCase.assertTrue;

public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();

    @Test(expected = UserAlreadyExistsException.class)
    public void testExistedRegistration() throws UserAlreadyExistsException {
        userService.registration("login1", "password");
    }

    @Test
    public void testNewRegistration() throws UserAlreadyExistsException {
        assertTrue(userService.registration("newLogin", "newPassword"));
    }

}