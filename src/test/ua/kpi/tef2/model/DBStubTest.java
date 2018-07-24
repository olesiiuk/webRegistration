package ua.kpi.tef2.model;


import org.junit.Test;
import ua.kpi.tef2.model.db.DBStub;
import ua.kpi.tef2.model.exceptions.UserAlreadyExistsException;

import static org.junit.Assert.*;

public class DBStubTest {

    @Test(expected = UserAlreadyExistsException.class)
    public void isPresent() throws UserAlreadyExistsException {
        String login = "login1";
        String password = "password1";

        DBStub.FIRST.registration(login, password);
    }

    @Test
    public void isNotPresent() throws UserAlreadyExistsException {
        String login = "login";
        String password = "password";

        assertTrue(DBStub.FIRST.registration(login, password));
    }

}