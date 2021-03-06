package com.maksim.controller.comand;

import com.maksim.controller.manager.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
/*в случае прямого обращения к контроллеру переадресация на страницу ввода
логина*/
        String page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);

        return page;
    }
}