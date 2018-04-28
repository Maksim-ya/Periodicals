package com.maksim.controller.manager;

import com.maksim.domain.Subscription;
import com.maksim.domain.User;
import com.maksim.model.impl.SubscriptionDaoImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserSession {
    private static final String PARAM_USER = "user";
    private static final String PARAM_USERNAME = "name";
    private static final String PARAM_SUBSCRITIONS = "listOfSubscriptions";


    public static String loadUserDataToSession(HttpServletRequest request, User user) {
        String page;
        HttpSession se = request.getSession(true);
        se.setAttribute(PARAM_USER, user);
        se.setAttribute(PARAM_USERNAME, user.getFullName());


            if (se.getAttribute("isPublication") != null) {
                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
            } else {
                SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
                List<Subscription> list = subscriptionDao.findSubscriptionsByUser(user.getUserId());
                request.setAttribute(PARAM_SUBSCRITIONS, list);

                //определение пути к main.jsp
                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);
            }
//        }
        return page;
    }
}

