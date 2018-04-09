package com.maksim.controller.comand.publication;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.domain.Publication;
import com.maksim.model.dao.PublicationDAO;
import com.maksim.model.impl.PublicationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Максим on 09/Apr/18.
 */
public class PublicationListCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        PublicationDaoImpl dao = new PublicationDaoImpl();
        List<Publication> list =  dao.findAll();
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }

        request.setAttribute("listOfPublications", list);

        page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ALLPUBLICATIONS_PAGE_PATH);

        return page;
    }
}
