package task3;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class Values {
    public int id;
    public String value;

    public List<String> listString;


    public void setValue() throws IOException, ParseException {


        JSONParser parser = new JSONParser();
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\values.json"));
        JSONArray values = (JSONArray) objectValues.get("values");

        for (Object c : values)
            {
                JSONObject ss = (JSONObject) c;

                long id = (long) ss.get("id");
                System.out.println(id);

                String value = (String) ss.get("value");
                System.out.println(value);

                System.out.println();




//                System.out.println(c+"");
            }



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
}
