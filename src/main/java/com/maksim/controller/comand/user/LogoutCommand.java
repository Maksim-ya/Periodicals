package com.maksim.controller.comand.user;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        request.setAttribute("logoutMessage",MessageManager.getInstance().getProperty(MessageManager.SUCCESS_LOGOUT_MESSAGE));

        return page;
    }
}
