package mirea.mosit.serversfy.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import mirea.mosit.serversfy.domain.Data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClientForCloud {
    public Data getJson(Client client, String url) throws ParseException {

        WebResource webResource = client.resource("https://dev.rightech.io/api/v1/objects/" + url);

        ClientResponse response = webResource.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiI2MDg4MWNkZjYwZjRlOTAwMTAyYjc5YzciLCJzdWIiOiI1ZjhkODYxMmUxODgzY2ZiZmQxNzI0MzUiLCJncnAiOiI1ZjhkODYxMmUxODgzYzVkMzExNzI0MzQiLCJsaWMiOnRydWUsInVzZyI6ImFwaSIsImZ1bGwiOmZhbHNlLCJyaWdodHMiOjEuNSwiaWF0IjoxNjE5NTMzMDIzLCJleHAiOjE2MjIwNjI4MDB9.wU_Ni3OW0xaP-HYN0zezEeyokl1PVGTZDZz5DiK16i4").accept("application/json").get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            //return null;
        }
        String output = response.getEntity(String.class);
        System.out.println("Output from cloud .... \n");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(output);
        JSONObject json = (JSONObject) jsonObject.get("state");
        Data data = new Data((String) jsonObject.get("id"), json.get("sensor_action").toString(), json.get("sensor_rele").toString(), json.get("time_action").toString(), json.get("time_rele").toString());
        return data;
    }
}
