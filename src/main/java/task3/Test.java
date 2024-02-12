package task3;

import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public long id;
    public String title;
    public String value;

    public static List<Test> meaningValuesTasta = new ArrayList<>();

    public void setValue() throws IOException, ParseException {

        List<JSONObject> valuesList = new ArrayList<>();                   //Удалить
        List<JSONArray> JSONArrayValues = new ArrayList<>();              //Удалить
        List<JSONObject> meaningValues = new ArrayList<>();                //Удалить

        List<Test> tastaList3 = new ArrayList<>();
        List<Test> tastaList4 = new ArrayList<>();

        JSONParser parser = new JSONParser();
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\tests.json"));
        JSONArray testsJSONArray = (JSONArray) objectValues.get("tests");


//        ObjectMapper mapper = new ObjectMapper();                 //в текст
//        String json = mapper.writeValueAsString(objectValues);



        valuesList.add(objectValues);
        JSONArrayValues.add(testsJSONArray);


        for (Object c : testsJSONArray) {                       //первый проход
            JSONObject jsonObjectValues = (JSONObject) c;


            meaningValues.add(jsonObjectValues);


            long id12 = (long) jsonObjectValues.get("id");
//                System.out.println(id12);

            String title = (String) jsonObjectValues.get("title");

            String value = (String) jsonObjectValues.get("value");
//                System.out.println(value);



            //------------------второй заход   начало

            JSONArray values = (JSONArray) jsonObjectValues.get("values");               //второй проход
            List<Test> tastaList = new ArrayList<>();
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





                     //------------------третий заход   начало

                    JSONArray values3 = (JSONArray) jsonObjectValues1.get("values");             //третий проход
                    tastaList3 = new ArrayList<>();
//            System.out.println(values3);
                    if( values3 !=  null) {
//                        JSONArrayValues.add(values3);

                        for (Object c3 : values3) {
                            JSONObject jsonObjectValues3 = (JSONObject) c3;
//                            meaningValues.add(jsonObjectValues3);


                            long id3 = (long) jsonObjectValues3.get("id");
//                System.out.println(id12);
//
                            String title3 = (String) jsonObjectValues3.get("title");
//
                            String value3 = (String) jsonObjectValues3.get("value");
//                System.out.println(value);


                            //------------------четвертый заход   начало

                            JSONArray values4 = (JSONArray) jsonObjectValues3.get("values");             //4 проход
                            tastaList4 = new ArrayList<>();

                            if( values4 !=  null) {

                                for (Object c4 : values4) {

                                    JSONObject jsonObjectValues4 = (JSONObject) c4;

                                    long id4 = (long) jsonObjectValues4.get("id");
//                System.out.println(id12);
//
                                    String title4 = (String) jsonObjectValues4.get("title");
//
                                    String value4 = (String) jsonObjectValues4.get("value");
//                System.out.println(value);

                                    Test valuesJSON = new Test(id4, title4, value4);
                                    tastaList4.add(valuesJSON);

                                }



                            }


                                        //------------------четвертый заход конец

                            if(values4 == null) {
                                Test valuesJSON = new Test(id3, title3, value3);
                                tastaList3.add(valuesJSON);
                            } else {
                                TestMoreMini valuesJSON = new TestMoreMini(id3, title3, tastaList4);
                                tastaList3.add(valuesJSON);         //TUT
//                                System.out.println(valuesJSON);

                            }

//                            TestMore tastaMore = new TestMore(id121, title1, value1, tastaList3);
//                            tastaList3.add(tastaMore);



                        }
                    }
                    //------------------третий заход конец




                    if(values3 == null) {
                        Test valuesJSON = new Test(id121, title1, value1);
                        tastaList.add(valuesJSON);
//                    System.out.println("tastaList = " + tastaList);
                    } else {
                        TestMore valuesJSON = new TestMore(id121, title1, value1, tastaList3);
                        tastaList.add(valuesJSON);
                    }
                }
            }
            ///------------------второй заход конец


            if( values ==  null) {
                Test testOne = new Test(id12, title, value);
                meaningValuesTasta.add(testOne);
//                System.out.println("meaningValuesValues = "+meaningValuesValues);
//                System.out.println("=-==-=-=-=-=-=-=-=-=");

            } else{

                if(tastaList3.size() == 0) {
                    TestMore testTwo = new TestMore(id12, title, value, tastaList);
                    meaningValuesTasta.add(testTwo);
//                                    System.out.println("++++++");

                } else {
                    TestMore testTree = new TestMore(id12, title, value, tastaList);
                    meaningValuesTasta.add(testTree);
//                                     System.out.println("----------");
//                    tastaList3.removeAll(tastaList3);

                }


//                System.out.println(tastaMore);
            }


        }
//        System.out.println(meaningValuesTasta);

        TastaStart tastaStart = new TastaStart(meaningValuesTasta);
        System.out.println(tastaStart);
    }

    public static void main(String[] args) throws IOException, ParseException {
        Test tasta = new Test();
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

    public static List<Test> getMeaningValuesTasta() {
        return meaningValuesTasta;
    }

    public static void setMeaningValuesTasta(List<Test> meaningValuesTasta) {
        Test.meaningValuesTasta = meaningValuesTasta;
    }

    public Test(long id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
