package com.maksim.controller.comand;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    String PARAM_USER = "user";
    String PARAM_PUBLICATION = "publication";
    String PARAM_PUBLICATION_ALL_ID = "publicationAllId";
    String PARAM_TOTAL_PRICE = "totalPrice";
    String PARAM_IS_PUBLICATION = "isPublication";


    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
