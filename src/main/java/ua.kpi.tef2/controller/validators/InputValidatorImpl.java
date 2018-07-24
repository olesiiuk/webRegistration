package ua.kpi.tef2.controller.validators;

import ua.kpi.tef2.controller.InputType;

import java.util.ResourceBundle;

public class InputValidatorImpl implements InputValidator {

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("RegExProperties");
        NAME_AND_LAST_NAME_REG_EX = resourceBundle.getString("regexp.nameAndLastName");
        COMMENT_REG_EX = resourceBundle.getString("regexp.comment");
        PHONE_REG_EX = resourceBundle.getString("regexp.phone");
        EMAIL_REG_EX = resourceBundle.getString("regexp.email");
        LOGIN_REG_EX = resourceBundle.getString("regexp.login");
        PASSWORD_REG_EX = resourceBundle.getString("regexp.password");
    }


    private static final String NAME_AND_LAST_NAME_REG_EX;
    private static final String COMMENT_REG_EX;
    private static final String PHONE_REG_EX;
    private static final String EMAIL_REG_EX;
    private static final String LOGIN_REG_EX;
    private static final String PASSWORD_REG_EX;

    public boolean validate(String inputType, String input) {
        String regEx = "";
        switch (inputType) {
            case InputType.NAME:
                regEx = NAME_AND_LAST_NAME_REG_EX;
                break;
            case InputType.LAST_NAME:
                regEx = NAME_AND_LAST_NAME_REG_EX;
                break;
            case InputType.COMMENT:
                regEx = COMMENT_REG_EX;
                break;
            case InputType.PHONE:
                regEx = PHONE_REG_EX;
                break;
            case InputType.EMAIL:
                regEx = EMAIL_REG_EX;
                break;
            case InputType.LOGIN:
                regEx = LOGIN_REG_EX;
                break;
            case InputType.PASSWORD:
                regEx = PASSWORD_REG_EX;
                break;
        }
        return input.matches(regEx);

    }
}
