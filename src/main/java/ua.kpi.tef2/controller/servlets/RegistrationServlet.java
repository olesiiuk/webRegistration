package ua.kpi.tef2.controller.servlets;

import ua.kpi.tef2.controller.InputType;
import ua.kpi.tef2.controller.validators.InputValidator;
import ua.kpi.tef2.controller.validators.InputValidatorImpl;
import ua.kpi.tef2.model.exceptions.UserAlreadyExistsException;
import ua.kpi.tef2.model.service.UserService;
import ua.kpi.tef2.model.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kpi.tef2.controller.servlets.ServletVariables.*;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private String SUCCESSFUL_LOGIN_PARAM = "successLoginMessage";
    private String SUCCESSFUL_LOGIN_MESSAGE = "You have been successfully registered!";
    private String ERROR_MESSAGE_PARAM = "errorMessage";
    private String LOGIN_EXISTS_MESSAGE = "loginExistsMessage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(ENCODING);

        req.getRequestDispatcher(REGISTRATION_JSP_NAME).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(ENCODING);

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        String errorMessage = validateLoginAndPassword(login, password);
        if (errorMessage != null) {
            req.setAttribute(ERROR_MESSAGE_PARAM, errorMessage);
            req.getRequestDispatcher(REGISTRATION_JSP_NAME).forward(req, resp);
            return;
        }

        try {
            userService.registration(login, password);
        } catch (UserAlreadyExistsException e) {
            req.setAttribute(LOGIN_EXISTS_MESSAGE, e.getMessage());
            req.getRequestDispatcher(REGISTRATION_JSP_NAME).forward(req, resp);
            return;
        }

        req.setAttribute(SUCCESSFUL_LOGIN_PARAM, SUCCESSFUL_LOGIN_MESSAGE);
        req.getRequestDispatcher(REGISTRATION_JSP_NAME).forward(req, resp);
    }

    private String validateLoginAndPassword(String login, String password) {

        InputValidator validator = new InputValidatorImpl();

        String errorMessage = null;
        if (!validator.validate(InputType.LOGIN, login)) {
            errorMessage = InputType.LOGIN + InputType.ERROR_SUFFIX;
        }
        if (!validator.validate(InputType.PASSWORD, password)) {
            errorMessage = InputType.PASSWORD + InputType.ERROR_SUFFIX;
        }

        return errorMessage;
    }

}
