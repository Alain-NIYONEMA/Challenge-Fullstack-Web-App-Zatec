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
        } catch (NumberFormatException e) {
            number = placeholder;
        }
        return number;
    }


    /**
     convert JsonArray to List
     */
    public static List<String> toArray(JsonArray jsonArray) {
        List<String> list = new ArrayList<>();
        for(JsonElement element : jsonArray) {
            list.add(element.getAsString());
        }
        return list;
    }


    /**
    convert JSOn String to JsonArray
     */
    public static JsonArray toJsonArray(String json) {
        JsonArray jsonArray;

        try {
            jsonArray = JsonParser.parseString(json).getAsJsonArray();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            jsonArray = new JsonArray();
        }

        return jsonArray;
    }


    /**
    convert JSOn String to JsonObject
     */
    public static JsonObject toJsonObject(String json) {
        JsonObject jsonObject;

        try {
            jsonObject = JsonParser.parseString(json).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            jsonObject = new JsonObject();
        }

        return jsonObject;
    }

}