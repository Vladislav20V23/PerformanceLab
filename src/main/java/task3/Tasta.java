package task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tasta {

    public long id;
    public String title;
    public String value;

    public static List<Tasta> meaningValuesTasta = new ArrayList<>();

    public void setValue() throws IOException, ParseException {

        List<JSONObject> valuesList = new ArrayList<>();                   //Удалить
        List<JSONArray> JSONArrayValues = new ArrayList<>();              //Удалить
        List<JSONObject> meaningValues = new ArrayList<>();                //Удалить



        JSONParser parser = new JSONParser();
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\tests.json"));
        JSONArray tests = (JSONArray) objectValues.get("tests");


        valuesList.add(objectValues);
        JSONArrayValues.add(tests);


        for (Object c : tests) {
            JSONObject jsonObjectValues = (JSONObject) c;


            meaningValues.add(jsonObjectValues);


            long id12 = (long) jsonObjectValues.get("id");
//                System.out.println(id12);

            String title = (String) jsonObjectValues.get("title");

            String value = (String) jsonObjectValues.get("value");
//                System.out.println(value);



            //---------------------

            JSONArray values = (JSONArray) jsonObjectValues.get("values");
            List<Tasta> tastaList = new ArrayList<>();
//            System.out.println(values);
            if( values !=  null) {
                JSONArrayValues.add(values);

                for (Object c1 : values) {
                    JSONObject jsonObjectValues1 = (JSONObject) c1;
                    meaningValues.add(jsonObjectValues1);


                    long id121 = (long) jsonObjectValues1.get("id");
//                System.out.println(id12);

                    String title1 = (String) jsonObjectValues1.get("title");

                    String value1 = (String) jsonObjectValues1.get("value");
//                System.out.println(value);






                    Tasta valuesJSON = new Tasta(id121, title1, value1);
                    tastaList.add(valuesJSON);

                }
            }
            //----------------


            if( values ==  null) {
                Tasta valuesJSON = new Tasta(id12, title, value);
                meaningValuesTasta.add(valuesJSON);
//                System.out.println("meaningValuesValues = "+meaningValuesValues);
            } else{
                TastaMore tastaMore = new TastaMore(id12, title, value, tastaList);
                meaningValuesTasta.add(tastaMore);
//                System.out.println(tastaMore);
            }


        }
//        System.out.println(meaningValuesTasta);

        TastaStart tastaStart = new TastaStart(meaningValuesTasta);
        System.out.println(tastaStart);
    }

    public static void main(String[] args) throws IOException, ParseException {
        Tasta tasta = new Tasta();
        tasta.setValue();


    }










    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tasta(long id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public Tasta() {
    }

    @Override
    public String toString() {
        return "Tasta{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
