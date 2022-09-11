package alain.niyonema.zatec;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


@WebServlet(name = "APIServlet", value = "/api")
public class APIServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        String link = "https://www.anapioficeandfire.com/api/houses?";

        if(page != null && !page.isEmpty()) {
            link += "page=" + page;
        }

        if(pageSize != null && !pageSize.isEmpty()) {
            link += "pageSize=" + pageSize;
        }

        // fetch the API url
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");

        // get response content
        String responseMessage;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        StringBuilder stringBuilder = new StringBuilder();
        while ((responseMessage = bufferedReader.readLine()) != null) {
            stringBuilder.append(responseMessage);
        }

        // parse response content
        responseMessage = stringBuilder.toString();

        connection.disconnect();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(responseMessage.toString());
    }

    public void destroy() {

    }

}