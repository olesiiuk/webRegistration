package ua.kpi.tef2.controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kpi.tef2.controller.servlets.ServletVariables.*;

@WebServlet(value = "")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test", "Some test text");
        req.getRequestDispatcher(HELLO_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(ENCODING);

        String language = req.getParameter(LANGUAGE_PARAM);

        req.setAttribute(ERROR_MESSAGE_PARAM, null);
        req.setAttribute(LANGUAGE_PARAM, language);
        req.getRequestDispatcher(REGISTRATION_JSP_NAME).forward(req, resp);
    }


}
