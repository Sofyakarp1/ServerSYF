package mirea.mosit.serversfy.parse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseFromJson {
    String jsonString;

    public ParseFromJson(String jsonString) {
        this.jsonString = jsonString;
    }

    public JSONObject createObject() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
        return jsonObject;
    }
}
