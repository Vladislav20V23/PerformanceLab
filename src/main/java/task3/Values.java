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
    public long id;
    public String value;




    public static List<Values> meaningValuesValues = new ArrayList<>();


//    Map<JSONObject, JSONArray[]> values = new HashMap<>();
//    Map<String, Integer> valuesDetails = new HashMap<>();




    public void setValue() throws IOException, ParseException {

         List<JSONObject> valuesList = new ArrayList<>();                   //Удалить
          List<JSONArray> JSONArrayValues = new ArrayList<>();              //Удалить
         List<JSONObject> meaningValues = new ArrayList<>();                //Удалить

        JSONParser parser = new JSONParser();
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\values.json"));
        JSONArray values = (JSONArray) objectValues.get("values");

        valuesList.add(objectValues);
        JSONArrayValues.add(values);


        for (Object c : values)
            {
                JSONObject jsonObjectValues = (JSONObject) c;



                meaningValues.add(jsonObjectValues);


                long id12 = (long) jsonObjectValues.get("id");
//                System.out.println(id12);

                String value = (String) jsonObjectValues.get("value");
//                System.out.println(value);

                Values valuesJSON = new Values(id12,value);
                meaningValuesValues.add(valuesJSON);
//                System.out.println("meaningValuesValues = "+meaningValuesValues);



            }

        System.out.println("meaningValuesValues = "+meaningValuesValues);


        String lisMas = meaningValues.toString();           //String values
//        System.out.println("---------------" + lisMas);
        Gson gson = new Gson();
        Values[] values22 =gson.fromJson(lisMas, Values[].class);
//        System.out.println(Arrays.toString(values22));
//        System.out.println(values22[4]);







    }








    public static void main(String[] args) throws IOException, ParseException {

        Values a = new Values();
        a.setValue();
//        System.out.println("a.meaningValuesValues.get(0).getId(); = " + a.meaningValuesValues.get(0).getId() +" "+ a.meaningValuesValues.get(0).getValue());


    }


    public long getId() {
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




    public Values(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Values() {
    }

    @Override
    public String toString() {
        return "Values{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
