package ua.kpi.tef2.model.db;

import ua.kpi.tef2.model.exceptions.UserAlreadyExistsException;

public enum DBStub {

    FIRST("login1", "password1"),
    SECOND("login2", "password2"),
    THIRD("login3", "password3"),
    FOURTH("login4", "password4"),
    FIFTH("login5", "password5");

    private String login;

    private String password;

    DBStub(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean registration(String login, String password) throws UserAlreadyExistsException {
        for (DBStub record : DBStub.values()) {
            if (record.login.equalsIgnoreCase(login)) {
                throw new UserAlreadyExistsException(login);
            }
        }

        return true;
    }
}
