package com.maksim.controller.comand;

import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Максим on 17/Apr/18.
 */
public class BuyPageCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession se = request.getSession();
        User user = (User) se.getAttribute("user");
        if (user != null) {
            request.setAttribute("user", user);
            request.setAttribute("name", user.getFullName());
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
        }
        else
        {
            page=ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
        }
        return page;
    }
}
