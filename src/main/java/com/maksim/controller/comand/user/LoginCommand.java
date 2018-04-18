package com.maksim.controller.comand.user;

import com.maksim.controller.LoginLogic;
import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
//извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        User user = LoginLogic.checkLogin(login, pass);
//проверка логина и пароля

        if (user != null) {
            HttpSession se = request.getSession();
            se.setAttribute("user", user);
            se.setAttribute("name", user.getFullName());
//            request.setAttribute("user", user);
//            request.setAttribute("name", user.getFullName());

//определение пути к main.jsp
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);

        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.LOGIN_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}

