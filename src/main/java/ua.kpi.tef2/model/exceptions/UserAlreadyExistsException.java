package ua.kpi.tef2.model.exceptions;

public class UserAlreadyExistsException extends Exception {
    private String ERROR_MESSAGE_FORMAT = "Login [ %s ] already exists, pleas enter another login";

    private String login;

    public UserAlreadyExistsException(String login) {
        this.login = login;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, login);
    }
}
