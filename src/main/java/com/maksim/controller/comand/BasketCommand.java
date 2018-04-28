package com.maksim.controller.comand;

import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.Publication;
import com.maksim.domain.User;
import com.maksim.model.dao.PublicationDAO;
import com.maksim.model.impl.PublicationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Максим on 17/Apr/18.
 */
public class BasketCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute("user");

<<<<<<< HEAD
=======
//        se.getAttribute("publication");
>>>>>>> origin/master
        PublicationDAO publicationDAO = new PublicationDaoImpl();
        int publicationAllId = publicationDAO.findAllId().size();
        se.setAttribute("publicationAllId", publicationAllId);

//        java.util.Enumeration cats = request.getAttributeNames();
//        List<Object> list = java.util.Collections.list(cats);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        for (int i = 1; i <= publicationAllId; i++) {
            String publicationId = request.getParameter("publicationId" + i);
            if (publicationId != null) {
                Publication publication = publicationDAO.findById(Integer.parseInt(publicationId));
<<<<<<< HEAD
                se.setAttribute("isPublication", "?//D");
=======
//                System.out.println(publication);
>>>>>>> origin/master
                se.setAttribute("publication" + i, publication);
            }
        }

//        String publicationId = request.getParameter("publicationId");
//
//        PublicationDAO publicationDAO = new PublicationDaoImpl();
//        Publication publication = publicationDAO.findById(Integer.parseInt(publicationId));
//        se.setAttribute("publication", publication);

//            System.out.println("______________________");
//            System.out.println(publication);
//            System.out.println("______________________");


//       Integer publicationId = (Integer) se.getAttribute("publication.publicationId");
//        System.out.println(publicationId);
//        String publicationId = request.getParameter("publicationId");

        if (user != null) {
<<<<<<< HEAD
            page = UserSession.loadUserDataToSession(request, user);

=======
//            se.setAttribute("user", user);
//            se.setAttribute("name", user.getFullName());
//            se.setAttribute("publication", publication);
            page = UserSession.loadUserDataToSession(request, user);
//            page =ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);


//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
>>>>>>> origin/master
        } else {
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
        }
        return page;
    }
}
