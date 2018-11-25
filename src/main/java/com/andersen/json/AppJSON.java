package com.andersen.json;

import com.andersen.json.entity.PersonJSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppJSON {


    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        PersonJSON personJSON = new PersonJSON("ready");

        jsonObject.put("id", personJSON.getId());
        jsonObject.put("name", personJSON.getName());
        jsonObject.put("surname", personJSON.getSurname());
        jsonObject.put("age", personJSON.getAge());
        jsonObject.put("phone", personJSON.getPhoneNumber());

        try {
            FileWriter fileWriter = new FileWriter("person.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser jsonParser = new JSONParser();
        PersonJSON personJSON1 = new PersonJSON();
        try {
            jsonObject = (JSONObject) jsonParser.parse(
                    new FileReader("C:\\Users\\katya\\IdeaProjects\\json_xml\\person.json"));

            personJSON1.setId((Long) jsonObject.get("id"));
            personJSON1.setName((String) jsonObject.get("name"));
            personJSON1.setSurname((String) jsonObject.get("surname"));
            personJSON1.setAge((Long) jsonObject.get("age"));
            personJSON1.setPhoneNumber((String) jsonObject.get("phone"));

            System.out.println("+++++After parser++++++++");
            System.out.println(personJSON1.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
