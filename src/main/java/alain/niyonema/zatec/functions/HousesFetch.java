package alain.niyonema.zatec.functions;

import alain.niyonema.zatec.constants.HouseParams;
import alain.niyonema.zatec.models.House;
import alain.niyonema.zatec.utils.AlnUtils;
import alain.niyonema.zatec.utils.HouseUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class HousesFetch {


    public String processRequest(HttpServletRequest request) throws IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        String link = HouseParams.SERVER_API_LINK;

        if(!AlnUtils.isEmpty(id)) {
            link += "/" + id;
        }

        link += "?";

        if(!AlnUtils.isEmpty(name)) {
            link += "&name=" + name;
        }

        if(!AlnUtils.isEmpty(page)) {
            link += "&page=" + page;
        }

        if(!AlnUtils.isEmpty(pageSize)) {
            link += "&pageSize=" + pageSize;
        }


        int offset = 0;
        int pageNo = AlnUtils.toInt(page, 0);
        int pageSizeNo = AlnUtils.toInt(pageSize, 0);


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



        // get houses JSON data
        String jsonData;

        if(AlnUtils.isEmpty(id)) {
            // get list of houses

            JsonArray jsonArray = AlnUtils.toJsonArray(responseMessage);

            jsonData = jsonArray.toString();

            List<House> listHouses = HouseUtils.fromJSON(jsonArray);

        }else {
            // get a single house

            JsonObject jsonObject = AlnUtils.toJsonObject(responseMessage);

            jsonData = jsonObject.toString();

            House house = HouseUtils.fromJSON(jsonObject);

        }

        return jsonData;
    }

}