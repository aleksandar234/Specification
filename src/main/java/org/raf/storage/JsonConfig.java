package org.raf.storage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class JsonConfig {

    private static String jsonFileName = "config.json";
    private static final int fileSize = 1024;

    public static void mkJsonFile(String storagePath, int fileSize) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("max_file_size", fileSize);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("XML");
        jsonArray.add("MP3");
        jsonObject.put("blocked_extensions", jsonArray);

        try {
            FileWriter fileWriter = new FileWriter(new File(storagePath + File.separator + jsonFileName));
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkJsonFile(String storagePath) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("max_file_size", fileSize);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("XML");
        jsonArray.add("MP3");
        jsonObject.put("blocked_extensions", jsonArray);

        try {
            FileWriter fileWriter = new FileWriter(new File(storagePath + File.separator + jsonFileName));
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changePropertyValueJson(String key, Object size, String storagePath) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object object = jsonParser.parse(new FileReader(storagePath + File.separator + jsonFileName));
            JSONObject jsonObject = (JSONObject) object;
            jsonObject.put(key, size);
            PrintWriter printWriter = new PrintWriter(new File(storagePath + File.separator + jsonFileName));
            printWriter.write(jsonObject.toJSONString());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void changePropertyArrayJson(String key, List<String> extensions, String storagePath) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object object = jsonParser.parse(new FileReader(storagePath + File.separator + jsonFileName));
            JSONObject jsonObject = (JSONObject) object;
            jsonObject.put(key, extensions);
            PrintWriter printWriter = new PrintWriter(new File(storagePath + File.separator + jsonFileName));
            printWriter.write(jsonObject.toJSONString());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Object getPropertyJson(String key, String storagePath) {
        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try {
            Object object = jsonParser.parse(new FileReader(storagePath + File.separator + jsonFileName));
            JSONObject jsonObject = (JSONObject) object;
            obj = jsonObject.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean isExtensionBlocked(String key, String storagePath) {
        JSONArray jsonArray = (JSONArray) getPropertyJson("blocked_extensions", storagePath);
        for(Object obj: jsonArray){
            String name = (String) obj;
            if(name.equals(key)) return true;
        }
        return false;
    }

}
