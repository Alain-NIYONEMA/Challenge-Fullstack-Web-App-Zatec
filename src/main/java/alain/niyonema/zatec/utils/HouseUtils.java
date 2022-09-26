/*
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
  Project: ztc-Alain
  Company: Zatec
*/
package alain.niyonema.zatec.utils;

import alain.niyonema.zatec.constants.Config;
import alain.niyonema.zatec.constants.HouseParams;
import alain.niyonema.zatec.models.House;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;


public class HouseUtils {

    /**
     convert JsonArray into list of House objects
     @return List<House>
     */
    public static List<House> fromJSON(JsonArray jsonArray, String keyword, int offset, int pageSize, boolean match, String filter) {
        List<House> listHouses;

        if(jsonArray != null) {

            listHouses = new ArrayList<>();

            int i = 0;
            for (JsonElement element : jsonArray) {

                House house = fromJSON(element.getAsJsonObject());

                if(AlnUtils.isEmpty(keyword)) {
                    // with no query keyword, add all without filterinf
                    i++;

                    listHouses.add(house);

                }else {
                    // with query keyword

                    String keywords = "";

                    if(!AlnUtils.isEmpty(filter)) {
                        match = false;

                        // with filtering by region only
                        if(filter.equalsIgnoreCase("region")) {
                            keywords += (" "+ house.getRegion()).toLowerCase();

                            // with filtering in whole contents
                        }else if(filter.equalsIgnoreCase("all")) {
                            keywords += (""+ house.getName() +" "+ house.getCoatOfArms() +" "+ house.getRegion()).toLowerCase();
                        }

                    }else {
                        // with filtering by title only
                        keywords = (""+ house.getName()).toLowerCase();
                    }

                    boolean equal = house.getName().equalsIgnoreCase(keyword);
                    boolean like = keywords.contains(keyword.toLowerCase());

                    // check conditions before adding a result in the list
                    if((match && equal) || (!match && like)) {
                        i++;

                        // check the starting result
                        if(i <= offset) {
                            continue;
                        }

                        // check the ending result
                        if(i > offset + pageSize) {
                            break;
                        }

                        listHouses.add(house);
                    }

                }

            }

            return listHouses;
        }

        return null;
    }


    /**
    *convert JsonObject into House object
     * @return House
     */
    public static House fromJSON(JsonObject jsonObject) {

        if(jsonObject != null) {

            House house = new House();

            if(jsonObject.has(HouseParams.DATA_URL)) {
                String url = jsonObject.get(HouseParams.DATA_URL).getAsString();
                int index = url.lastIndexOf("/");
                int id = AlnUtils.toInt(url.substring(index+1), 0);
                house.setId(id);
                house.setUrl(Config.APP_URL +"?id="+ id);
            }

            if(jsonObject.has(HouseParams.DATA_NAME)) {
                house.setName(jsonObject.get(HouseParams.DATA_NAME).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_REGION)) {
                house.setRegion(jsonObject.get(HouseParams.DATA_REGION).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_COAT_OF_ARMS)) {
                house.setCoatOfArms(jsonObject.get(HouseParams.DATA_COAT_OF_ARMS).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_WORDS)) {
                house.setWords(jsonObject.get(HouseParams.DATA_WORDS).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_CURRENT_LOAD)) {
                house.setCurrentLord(jsonObject.get(HouseParams.DATA_CURRENT_LOAD).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_HEIR)) {
                house.setHeir(jsonObject.get(HouseParams.DATA_HEIR).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_OVERLOAD)) {
                house.setOverlord(jsonObject.get(HouseParams.DATA_OVERLOAD).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_FOUNDED)) {
                house.setFounded(jsonObject.get(HouseParams.DATA_FOUNDED).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_FOUNDER)) {
                house.setFounder(jsonObject.get(HouseParams.DATA_FOUNDER).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_DIED_OUT)) {
                house.setDiedOut(jsonObject.get(HouseParams.DATA_DIED_OUT).getAsString());
            }

            if(jsonObject.has(HouseParams.DATA_ANCESTRAL_WEAPONS)) {
                List<String> ancestralWeapons = AlnUtils.toList(jsonObject.get(HouseParams.DATA_ANCESTRAL_WEAPONS).getAsJsonArray());
                house.setAncestralWeapons(ancestralWeapons);
            }

            if(jsonObject.has(HouseParams.DATA_CADET_BRANCHES)) {
                List<String> cadetBranches = AlnUtils.toList(jsonObject.get(HouseParams.DATA_CADET_BRANCHES).getAsJsonArray());
                house.setCadetBranches(cadetBranches);
            }

            if(jsonObject.has(HouseParams.DATA_TITLES)) {
                List<String> titles = AlnUtils.toList(jsonObject.get(HouseParams.DATA_TITLES).getAsJsonArray());
                house.setTitles(titles);
            }

            if(jsonObject.has(HouseParams.DATA_SEATS)) {
                List<String> seats = AlnUtils.toList(jsonObject.get(HouseParams.DATA_SEATS).getAsJsonArray());
                house.setSeats(seats);
            }

            if(jsonObject.has(HouseParams.DATA_SWORN_MEMBERS)) {
                List<String> swornMembers = AlnUtils.toList(jsonObject.get(HouseParams.DATA_SWORN_MEMBERS).getAsJsonArray());
                house.setSwornMembers(swornMembers);
            }

            return house;
        }

        return null;
    }


    /**
     * converts a list of houses to a Json array
     * @return JsonArray
     */
    public static JsonArray toJsonArray(List<House> listHouses) {
        JsonArray jsonArray;

        if(listHouses != null) {

            jsonArray = new JsonArray();

            for(House house : listHouses) {

                JsonObject jsonObject = toJsonObject(house);

                jsonArray.add(jsonObject);

            }

            return jsonArray;
        }

        return null;
    }

    /**
    * convert a house object to JsonObject
     * @return JsonObject
     */
    public static JsonObject toJsonObject(House house) {
        JsonObject jsonObject;

        if(house != null) {

            jsonObject = new JsonObject();

            jsonObject.addProperty(HouseParams.DATA_ID, house.getId());
            jsonObject.addProperty(HouseParams.DATA_URL, house.getUrl());
            jsonObject.addProperty(HouseParams.DATA_NAME, house.getName());
            jsonObject.addProperty(HouseParams.DATA_REGION, house.getRegion());
            jsonObject.addProperty(HouseParams.DATA_COAT_OF_ARMS, house.getCoatOfArms());
            jsonObject.addProperty(HouseParams.DATA_WORDS, house.getWords());
            jsonObject.addProperty(HouseParams.DATA_CURRENT_LOAD, house.getCurrentLord());
            jsonObject.addProperty(HouseParams.DATA_HEIR, house.getHeir());
            jsonObject.addProperty(HouseParams.DATA_OVERLOAD, house.getOverlord());
            jsonObject.addProperty(HouseParams.DATA_FOUNDED, house.getFounded());
            jsonObject.addProperty(HouseParams.DATA_FOUNDER, house.getFounder());
            jsonObject.addProperty(HouseParams.DATA_DIED_OUT, house.getDiedOut());
            jsonObject.add(HouseParams.DATA_ANCESTRAL_WEAPONS, AlnUtils.fromList(house.getAncestralWeapons()));
            jsonObject.add(HouseParams.DATA_CADET_BRANCHES, AlnUtils.fromList(house.getCadetBranches()));
            jsonObject.add(HouseParams.DATA_TITLES, AlnUtils.fromList(house.getTitles()));
            jsonObject.add(HouseParams.DATA_SEATS, AlnUtils.fromList(house.getSeats()));
            jsonObject.add(HouseParams.DATA_SWORN_MEMBERS, AlnUtils.fromList(house.getSwornMembers()));

            return jsonObject;
        }

        return null;
    }


}