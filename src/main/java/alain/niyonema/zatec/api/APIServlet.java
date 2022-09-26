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

    // declaring an object to fetch houses
    HousesFetch housesFetch;

    public void init() {

        // initializing the houses fetching object
        housesFetch = new HousesFetch();

    }

    // GET Method: to get list of houses
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // calling the houses fetching function to retrieve for houses
        String responseMessageJson = housesFetch.processRequest(request);

        // return response in a json format
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(responseMessageJson);
    }

    // POST Method: to search for houses
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // calling the houses fetching function to search for houses
        String responseMessageJson = housesFetch.processRequest(request);

        // return response in a json format
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(responseMessageJson);
    }


    public void destroy() {

        // destroying the houses fetching object in the memory
        housesFetch = null;

    }

}