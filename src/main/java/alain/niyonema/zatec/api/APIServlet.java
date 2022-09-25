/*
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
  Project: ztc-Alain
  Company: Zatec
*/
package alain.niyonema.zatec.api;

import alain.niyonema.zatec.functions.HousesFetch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "APIServlet", value = "/api")
public class APIServlet extends HttpServlet {

    HousesFetch housesFetch;

    public void init() {

        housesFetch = new HousesFetch();

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String responseMessageJson = housesFetch.processRequest(request);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(responseMessageJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String responseMessageJson = housesFetch.processRequest(request);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(responseMessageJson);
    }


    public void destroy() {

        housesFetch = null;

    }

}