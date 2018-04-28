package com.maksim.controller.comand.subscription;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.Publication;
import com.maksim.domain.Subscription;
import com.maksim.domain.User;
import com.maksim.model.impl.SubscriptionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class SubscriptionPayCommand implements Command {

    private static final String PARAM_USER = "user";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
        int publicationAllId = (Integer)se.getAttribute("publicationAllId");

//        if(user.getAccount().compareTo(price) ==1 ){
        if (true) {

            Subscription subscription = new Subscription();
            SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
            for (int i = 1; i <= publicationAllId; i++) {
                Publication publication = (Publication) se.getAttribute("publication" + i);
                if (publication != null) {
                    subscription.setPublication(publication);
                    subscription.setUser(user);
                    subscriptionDao.addSubscription(subscription);

                    se.setAttribute("publication" + i,null);
                    se.setAttribute("isPublication",null);
                }
            }
            page = UserSession.loadUserDataToSession(request, user);
        }




//         java.util.Enumeration  cats = request.getAttributeNames();
//        List<Object> list =  java.util.Collections.list(cats);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


//        if(user.getAccount().compareTo(price) ==1 ){
//        if (true) {
//
//            SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();

//
//            subscriptionDao.addSubscription(subscription);
//
//            List<Subscription> list =  subscriptionDao.findSubscriptionsByUser(user.getUserId());
//            request.setAttribute("listOfSubscriptions", list);
//
//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);


//            subscription.setPublication(publication);

//            publisher.setMoney(publisher.getMoney().add(cost));
//            subscriber.setMoney(subscriber.getMoney().subtract(cost));
//
//            subscription.setUpdated(false);
//            subscription.setLastAvailableEntryDate(LocalDateTime.now());
//            subscriptionDao.update(subscription);
//        }
        else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.LOGIN_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }

        return page;
    }

}
