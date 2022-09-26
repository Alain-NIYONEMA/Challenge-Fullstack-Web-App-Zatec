/*
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
  Project: ztc-Alain
  Company: Zatec
*/
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
import java.net.URLEncoder;
import java.util.List;


public class HousesFetch {


    /**
     * this a function to fetch houses from the API through Http-connection
     * @param request
     * @return list of filtered houses as a String in json format
     * @throws IOException
     */
    public String processRequest(HttpServletRequest request) throws IOException {

        // retrieve request parameters
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        boolean match = Boolean.parseBoolean(request.getParameter("match"));
        String filter = request.getParameter("filter");


        // build URL parameter
        String params = "";

        if(!AlnUtils.isEmpty(id)) {
            params += "/" + id;
        }

        params += "?";

        if(!AlnUtils.isEmpty(name)) {
            int limit = 1000;
            if(match && AlnUtils.isEmpty(filter)) {
                params += "&name=" + URLEncoder.encode(name, "UTF-8");
            }
            params += "&page=" + 1;
            params += "&pageSize=" + limit;

        }else if(!AlnUtils.isEmpty(pageSize)) {

            if(!AlnUtils.isEmpty(page)) {
                params += "&page=" + page;
            }

            params += "&pageSize=" + pageSize;
        }

        // compute: page number, page size and offset
        int pageNo = AlnUtils.toInt(page, 1);
        int pageSizeNo = AlnUtils.toInt(pageSize, 10);
        int offset = pageNo <= 1 ? 0 : pageNo == 2 ? pageSizeNo : (pageNo * pageSizeNo) - pageSizeNo;

        // append PARS to URL
        String link = HouseParams.SERVER_API_URL_HOUSES +""+ params;

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
        responseMessage = stringBuilder.toString().replace(HouseParams.SERVER_API_URL, "");


        connection.disconnect();



        // get houses JSON data
        JsonObject jsonData = new JsonObject();

        if(AlnUtils.isEmpty(id)) {
            // get list of houses

            JsonArray jsonArray = AlnUtils.toJsonArray(responseMessage);

            String data = "{}";
            int counts = 0;

            List<House> listHouses = HouseUtils.fromJSON(jsonArray, name, offset, pageSizeNo, match, filter);

            if(listHouses != null && listHouses.size() > 0) {
                data = HouseUtils.toJsonArray(listHouses).toString();
                counts = listHouses.size();
            }

            // set results in json data
            jsonData.addProperty("data", data);
            jsonData.addProperty("counts", counts);

        }else {
            // get a single house

            JsonObject jsonObject = AlnUtils.toJsonObject(responseMessage);

            String data = "{}";
            int counts = 0;

            House house = HouseUtils.fromJSON(jsonObject);

            if(house != null) {
                data = HouseUtils.toJsonObject(house).toString();
                counts = 1;
            }

            // set results in json data
            jsonData.addProperty("data", data);
            jsonData.addProperty("counts", counts);

        }

        return jsonData.toString();
    }

}