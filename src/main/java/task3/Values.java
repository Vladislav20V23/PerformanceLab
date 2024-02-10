package task3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class Values {
    public int id;
    public String value;

    public List<String> listString;

    List<JSONObject> valuesList = new ArrayList<>();
    List<JSONArray> JSONArrayValues = new ArrayList<>();
    List<JSONObject> meaningValues = new ArrayList<>();


//    Map<JSONObject, JSONArray[]> values = new HashMap<>();
//    Map<String, Integer> valuesDetails = new HashMap<>();




    public void setValue() throws IOException, ParseException {


        JSONParser parser = new JSONParser();
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\values.json"));
        JSONArray values = (JSONArray) objectValues.get("values");

        valuesList.add(objectValues);
        JSONArrayValues.add(values);


        for (Object c : values)
            {
                JSONObject jsonObjectValues = (JSONObject) c;

                meaningValues.add(jsonObjectValues);

                long id = (long) jsonObjectValues.get("id");
                System.out.println(id);

                String value = (String) jsonObjectValues.get("value");
                System.out.println(value);

                System.out.println();




//                System.out.println(c+"");
            }

         System.out.println(meaningValues);

        String lisMas = meaningValues.toString();           //String values
        System.out.println(lisMas);






//        JSONParser parser = new JSONParser();
//        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\values2.json"));
//
//        for (Object o : a)
//        {
//            JSONObject person = (JSONObject) o;
//
//            String name = (String) person.get("name");
//            System.out.println(name);
//
//            String city = (String) person.get("city");
//            System.out.println(city);
//
//            String job = (String) person.get("job");
//            System.out.println(job);
//
//            JSONArray cars = (JSONArray) person.get("cars");
//
//            for (Object c : cars)
//            {
//                System.out.println(c+"");
//            }
//        }







    }



    public static void main(String[] args) throws IOException, ParseException {

        Values a = new Values();
        a.setValue();


    }


    @Override
    public String toString() {
        return "Values{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", listString=" + listString +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getListString() {
        return listString;
    }

    public void setListString(List<String> listString) {
        this.listString = listString;
    }

    public List<JSONObject> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<JSONObject> valuesList) {
        this.valuesList = valuesList;
    }

    public List<JSONArray> getJSONArrayValues() {
        return JSONArrayValues;
    }

    public void setJSONArrayValues(List<JSONArray> JSONArrayValues) {
        this.JSONArrayValues = JSONArrayValues;
    }

    public List<JSONObject> getMeaningValues() {
        return meaningValues;
    }

    public void setMeaningValues(List<JSONObject> meaningValues) {
        this.meaningValues = meaningValues;
    }
}
