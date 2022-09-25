/*
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
  Project: ztc-Alain
  Company: Zatec
*/
package alain.niyonema.zatec.utils;


import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;


public class AlnUtils {

    /**
    check if text is not empty
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }


    /**
    convert text to integer
     */
    public static int toInt(String text, int placeholder) {
        int number;
        try {
            number = Integer.parseInt(text);
            return number;
        } catch (NumberFormatException e) {
            return placeholder;
        }
    }


    /**
     convert JsonArray to List
     */
    public static List<String> toList(JsonArray jsonArray) {
        List<String> list = new ArrayList<>();
        for(JsonElement element : jsonArray) {
            list.add(element.getAsString());
        }
        return list;
    }


    /**
     convert JsonArray to List
     */
    public static JsonArray fromList(List<String> list) {
        JsonArray jsonArray = new JsonArray();
        for(String element : list) {
            jsonArray.add(element);
        }
        return jsonArray;
    }


    /**
    convert JSOn String to JsonArray
     */
    public static JsonArray toJsonArray(String json) {
        JsonArray jsonArray = null;

        try {
            JsonElement jsonElement = JsonParser.parseString(json);
            if(jsonElement != null) {
                jsonArray = jsonElement.getAsJsonArray();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }

        return jsonArray;
    }


    /**
    convert JSOn String to JsonObject
     */
    public static JsonObject toJsonObject(String json) {
        JsonObject jsonObject = null;

        try {
            JsonElement jsonElement = JsonParser.parseString(json);
            if(jsonElement != null) {
                jsonObject = jsonElement.getAsJsonObject();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }

        return jsonObject;
    }


}