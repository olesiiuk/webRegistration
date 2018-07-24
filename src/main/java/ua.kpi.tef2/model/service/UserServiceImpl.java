package ua.kpi.tef2.model.service;

import ua.kpi.tef2.model.db.DBStub;
import ua.kpi.tef2.model.exceptions.UserAlreadyExistsException;

public class UserServiceImpl implements UserService {

    @Override
    public boolean registration(String login, String password) throws UserAlreadyExistsException {
        return DBStub.FIRST.registration(login, password);
    }

}
