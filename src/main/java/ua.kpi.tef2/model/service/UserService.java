package ua.kpi.tef2.model.service;

import ua.kpi.tef2.model.exceptions.UserAlreadyExistsException;

public interface UserService {

    boolean registration(String login, String password) throws UserAlreadyExistsException;

}
