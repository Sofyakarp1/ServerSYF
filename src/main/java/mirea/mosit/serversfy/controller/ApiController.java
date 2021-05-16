package mirea.mosit.serversfy.controller;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import mirea.mosit.serversfy.client.ClientForCloud;
import mirea.mosit.serversfy.domain.Data;
import mirea.mosit.serversfy.domain.DataDAO;
import mirea.mosit.serversfy.entity.Observed;
import mirea.mosit.serversfy.service.AuthService;
import mirea.mosit.serversfy.service.ObservedService;
import mirea.mosit.serversfy.service.PersonService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@RestController
public class ApiController {

    @Autowired
    private ObservedService observedService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AuthService authService;


    @GetMapping("/cloud/object")
    public Data getData() throws ParseException {
        Client client = new Client();
        ClientForCloud clientForCloud = new ClientForCloud();
        return clientForCloud.getJson(client);
    }

    @GetMapping("/family_test")
    public JSONObject family() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse("{\n" +
                "  \"name\" : \"Ronaldo\",\n" +
                "  \"sport\" : \"soccer\",\n" +
                "  \"age\" : 25,\n" +
                "  \"id\" : 121,\n" +
                "  \"lastScores\" : [ 2, 1, 3, 5, 0, 0, 1, 1 ]\n" +
                "}");
        System.out.println("Пошла вода горячая!!!");
        return json;
    }

    /*
    @PostMapping("/sendData")
    public JSONObject fromCloud(){
        return null;
    }

     */

    @PostMapping(path = "/sendData", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody JSONObject member) {
        System.out.println("Было соединение");
        System.out.println(member);
    }

    @PostMapping(path = "/auth", consumes = "application/json", produces = "application/json")
    public JSONObject authorization(@RequestBody JSONObject member) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(member));
        if (checkAuth(json)){
            return (JSONObject) parser.parse(personService.getPersonByLogin(json.get("login").toString()).get(0).toString());
        }
            return null;
    }

    @PostMapping(path = "/dataObserved", consumes = "application/json", produces = "application/json")
    public JSONObject getDataObserved(@RequestBody JSONObject member)throws ParseException {
        JSONParser parser = new JSONParser();
        Observed observed = observedService.getDataObserved(
                ((JSONObject) parser.parse(String.valueOf(member)))
                        .get("login")
                        .toString())
                .get(0);
        JSONObject json = (JSONObject) parser.parse(observed.toString());
        return (JSONObject) parser.parse(observed.toString2());
    }

    public Boolean checkAuth(JSONObject json){
        String password = authService.getPassword(json.get("login").toString());
        if(password != null){
            return password.equals(json.get("password").toString());
        }
        else return false;
    }
}
