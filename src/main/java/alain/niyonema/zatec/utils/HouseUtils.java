package alain.niyonema.zatec.utils;

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
     */
    public static List<House> fromJSON(JsonArray jsonArray) {
        List<House> listHouses = new ArrayList<>();

        for(JsonElement element : jsonArray) {

            House house = fromJSON(element.getAsJsonObject());

            listHouses.add(house);

        }

        return listHouses;
    }


    /**
    convert JsonObject into House object
     */
    public static House fromJSON(JsonObject jsonObject) {

        if(jsonObject != null) {

            House house = new House();

            if(jsonObject.has(HouseParams.DATA_URL)) {
                String url = jsonObject.get(HouseParams.DATA_URL).getAsString();
                int index = url.lastIndexOf("/");
                int id = AlnUtils.toInt(url.substring(index), 0);
                house.setId(id);
            }

            if(jsonObject.has(HouseParams.DATA_NAME)) {
                house.setName(jsonObject.get(HouseParams.DATA_NAME).getAsString());
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
                List<String> ancestralWeapons = AlnUtils.toArray(jsonObject.get(HouseParams.DATA_ANCESTRAL_WEAPONS).getAsJsonArray());
                house.setAncestralWeapons(ancestralWeapons);
            }

            if(jsonObject.has(HouseParams.DATA_CADET_BRANCHES)) {
                List<String> cadetBranches = AlnUtils.toArray(jsonObject.get(HouseParams.DATA_CADET_BRANCHES).getAsJsonArray());
                house.setCadetBranches(cadetBranches);
            }

            if(jsonObject.has(HouseParams.DATA_TITLES)) {
                List<String> titles = AlnUtils.toArray(jsonObject.get(HouseParams.DATA_TITLES).getAsJsonArray());
                house.setTitles(titles);
            }

            if(jsonObject.has(HouseParams.DATA_SEATS)) {
                List<String> seats = AlnUtils.toArray(jsonObject.get(HouseParams.DATA_SEATS).getAsJsonArray());
                house.setSeats(seats);
            }

            if(jsonObject.has(HouseParams.DATA_SWORN_MEMBERS)) {
                List<String> swornMembers = AlnUtils.toArray(jsonObject.get(HouseParams.DATA_SWORN_MEMBERS).getAsJsonArray());
                house.setSwornMembers(swornMembers);
            }

            return house;
        }

        return null;
    }


}