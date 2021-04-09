package helper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Read Json file and return JsonObject
 */
public class JsonHelper {


    public JsonObject readJsonObjectFromFile(String path)
    {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        try { jsonObject= gson.fromJson(new FileReader(path), JsonObject.class); }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        return jsonObject;
    }
}
