package alain.niyonema.zatec.functions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Houses {

    public static String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        String link = "https://www.anapioficeandfire.com/api/houses";

        if(id != null && !id.isEmpty()) {
            link += "/" + id;
        }

        link += "?";

        if(name != null && !name.isEmpty()) {
            link += "&name=" + name;
        }

        if(page != null && !page.isEmpty()) {
            link += "&page=" + page;
        }

        if(pageSize != null && !pageSize.isEmpty()) {
            link += "&pageSize=" + pageSize;
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

        return responseMessage;
    }

}