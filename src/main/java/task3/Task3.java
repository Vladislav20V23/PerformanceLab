package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import task2.Task2;

public class Task3 {

    static String argumentOne;
    static String argumentTwo;
    static String argumentTree;

    public static void main(String[] args) throws IOException, ParseException {

        argumentOne = args[0];      //считывает первый аргумент
        argumentTwo = args[1];      //считывает two аргумент
        argumentTree = args[2];     //read tree args


        Values values = new Values();
        values.setValue();
        ValuesArray valuesArray = new ValuesArray(values.getMeaningValuesValues());
//        System.out.println( "ALL1 " + valuesArray);

        Test test = new Test();
        test.setValue();
        TastaStart tastaStart = new TastaStart(test.getMeaningValuesTasta());
//        System.out.println( "ALL2 " + tastaStart);




        for(int x=0; x<valuesArray.getValuesList().size();x++){                         //чтение Values
//            System.out.println( "id values " + valuesArray.getValuesList().get(x).getId());

            for(int y=0; y<tastaStart.getTests().size();y++) {                       //чтение tests и сверка ключь:значение //перебор верхнего уровня

                Test test1 = (Test) tastaStart.tests.get(y);


                try {
                    if (((TestMore) tastaStart.tests.get(y)).values.size() != 0 || ((TestMore) tastaStart.tests.get(y)).getValues().size() != 0) {

                        TestMore TestMoreGo = (TestMore) tastaStart.tests.get(y);

                        for (int b = 0; b < TestMoreGo.getValues().size(); b++) {
//                    System.out.println(testMoreTwo.getValues());
                            Test test2 = (Test) TestMoreGo.getValues().get(b);

                            for (int t = 0; t < TestMoreGo.values.size(); t++) {
                                TestMore testMore1 = (TestMore) TestMoreGo.values.get(t);

                                TestMoreMini testMoreMini = (TestMoreMini) testMore1.getValues().get(0);        //НЕТ ЦЫКЛА...

                                for (int r = 0; r < TestMoreGo.values.size(); r++) {

                                    Test testFinal = (Test) testMoreMini.getValues().get(r);


                                    if ((Objects.equals(valuesArray.getValuesList().get(x).getId(), testMore1.getId()) == true)) {
                                        testMore1.setValue(valuesArray.getValuesList().get(x).getValue());

                                    }

                                    if ((Objects.equals(valuesArray.getValuesList().get(x).getId(), testMoreMini.getId()) == true)) {
                                        // testMoreMini его нет т.к. объект не содержит value
                                    }

                                    if ((Objects.equals(valuesArray.getValuesList().get(x).getId(), testFinal.getId()) == true)) {
                                        testFinal.setValue(valuesArray.getValuesList().get(x).getValue());

                                    }

                                    if ((Objects.equals(valuesArray.getValuesList().get(x).getId(), test2.getId()) == true)) {
                                        test2.setValue(valuesArray.getValuesList().get(x).getValue());

                                    }
                                }
                            }
                        }

                    }
                }catch (Exception ex){}


                try {
                    TestMore TestMoreGo = (TestMore) tastaStart.tests.get(y);

                    for (int b = 0; b < TestMoreGo.getValues().size(); b++) {
//                     System.out.println(TestMoreGo.getValues().size());
                        Test test2 = (Test) TestMoreGo.getValues().get(b);
//                        System.out.println(test2);
                        if ((Objects.equals(valuesArray.getValuesList().get(x).getId(), test2.getId()) == true)) {
                            test2.setValue(valuesArray.getValuesList().get(x).getValue());

                        }
                    }
                }catch (Exception ec){}

                if ((Objects.equals(valuesArray.getValuesList().get(x).getId(), test1.getId()) == true)) {                //проверка присвоения

                    test1.setValue(valuesArray.getValuesList().get(x).getValue());

                }

            }
        }


//
//        System.out.println("00000000000000000000000000000000000000000000000000");
//        TestMore testMore = (TestMore) tastaStart.tests.get(2);
//        System.out.println( testMore);
//
//        System.out.println("00000000000000000000000000000000000000000000000000");
//        TestMore testMore1 = (TestMore) testMore.values.get(0);
//        System.out.println( testMore1);
//
//        System.out.println("00000000000000000000000000000000000000000000000000");
//        TestMoreMini testMoreMini = (TestMoreMini) testMore1.getValues().get(0);
//        System.out.println( testMoreMini);
//
//        System.out.println("00000000000000000000000000000000000000000000000000");
//        Test testFinal =(Test) testMoreMini.getValues().get(0);
//        System.out.println( testFinal);



//        System.out.println( tastaStart);

            Report report = new Report();
            report.valuesToJSON(tastaStart);

        System.out.println( "***********************");
        System.out.println( "Файл report.json сформирован");
        System.out.println( "***********************");


    }
}


class Report {                          // Запись в файл


    public void valuesToJSON(TastaStart tastaStart) throws IOException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


//        String json = ow.writeValueAsString(meaningValuesValues.get(0));      // список всех Values в виде String
//        System.out.println(json);
//        System.out.println(tastaStart);
        String json = ow.writeValueAsString(tastaStart);


      /*  Scanner scannerSystem = new Scanner(System.in);                             //ПЕРЕДАЧА АРГУМЕНТА в ручную
        System.out.println("Укажите путь для сохранения файла report.json :  ");
        String argumentOne = scannerSystem.nextLine();
        BufferedWriter bw=new BufferedWriter(new FileWriter(argumentOne));
*/

        //для тестирования(аргумент)
//        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\report.json"));

        String argumentTree = Task3.argumentTree;
        BufferedWriter bw=new BufferedWriter(new FileWriter(argumentTree));
        bw.append(json);
        bw.close();

        JsonParser parser = new JsonParser();                           //переобразование вариант2
        JsonObject JSONObject = parser.parse(json).getAsJsonObject();
//        System.out.println("Object: "+JSONObject);

    }

}


class Values {                          // ПЕРЕОБРАЗОВАНИЕ JSON in Object Values
    public long id;
    public String value;

    public static List<Values> meaningValuesValues = new ArrayList<>();

    public void setValue() throws IOException, ParseException {

//         List<JSONObject> valuesList = new ArrayList<>();                   //Удалить
//          List<JSONArray> JSONArrayValues = new ArrayList<>();              //Удалить
//         List<JSONObject> meaningValues = new ArrayList<>();                //Удалить

        JSONParser parser = new JSONParser();


       /* Scanner scannerSystem = new Scanner(System.in);                   //ПЕРЕДАЧА АРГУМЕНТА в ручную
        System.out.println("Укажите расположение файла values.jso:  ");
        String argumentOne = scannerSystem.nextLine();
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader(argumentOne));
        JSONArray values = (JSONArray) objectValues.get("values");
*/
        //для тестирования(аргумент)
//        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\values.json"));
//        JSONArray values = (JSONArray) objectValues.get("values");

        String argumentOne = Task3.argumentOne;
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader(argumentOne));
        JSONArray values = (JSONArray) objectValues.get("values");

//
//        valuesList.add(objectValues);
//        JSONArrayValues.add(values);


        for (Object c : values)
        {
            JSONObject jsonObjectValues = (JSONObject) c;



//                meaningValues.add(jsonObjectValues);


            long id12 = (long) jsonObjectValues.get("id");
//                System.out.println(id12);

            String value = (String) jsonObjectValues.get("value");
//                System.out.println(value);

            Values valuesJSON = new Values(id12,value);
            meaningValuesValues.add(valuesJSON);
//                System.out.println("meaningValuesValues = "+meaningValuesValues);

        }

        ValuesArray valuesArray = new ValuesArray(meaningValuesValues);

//        System.out.println(valuesArray);              //РЕЗУЛЬТАТ


//        String lisMas = meaningValues.toString();           //String values
//        System.out.println("---------------" + lisMas);
//        Gson gson = new Gson();
//        Values[] values22 =gson.fromJson(lisMas, Values[].class);
//        System.out.println(Arrays.toString(values22));
//        System.out.println(values22[4]);

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

    public static List<Values> getMeaningValuesValues() {
        return meaningValuesValues;
    }

    public static void setMeaningValuesValues(List<Values> meaningValuesValues) {
        Values.meaningValuesValues = meaningValuesValues;
    }

    @Override
    public String toString() {
        return "Values{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}

class ValuesArray extends Values{                       //вспомогательный класс для работы с листом объектов Values
    List<Values> values = new ArrayList<>();


    public ValuesArray(List<Values> valuesList) {
        this.values = valuesList;
    }

    public List<Values> getValuesList() {
        return values;
    }

    public void setValuesList(List<Values> valuesList) {
        this.values = valuesList;
    }

    @Override
    public String toString() {
        return "ValuesArray{" +
                "values=" + values +
                '}';
    }
}

class TastaStart  {                 // первый объект на переобразование JSON (самый верхний)

    public List<Object> tests = new ArrayList<>();

    public TastaStart(List<Object> tests){
        this.tests = tests;
    }

    public List<Object> getTests() {
        return tests;
    }

    public void setTests(List<Object> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "TastaStart{" +
                "tests=" + tests +
                '}';
    }
}

class TestMore extends Test{            //второй (объект содержит List<Object> values) объект для json

    public long id;
    public String title;
    public String value;

    public List<Object> values = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public TestMore() {
    }

    public TestMore(long id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public TestMore(long id, String title, String value, List<Object> meaningValuesTastaMore) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = meaningValuesTastaMore;
    }

    public TestMore(long id, String title, List<Object> meaningValuesTastaMore) {
        this.id = id;
        this.title = title;
        this.values = meaningValuesTastaMore;
    }
    public TestMore(List<Object> meaningValuesTastaMore) {
        this.values = meaningValuesTastaMore;
    }


    @Override
    public String toString() {
        return "TestMore{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}


class TestMoreMini  {                   // третий объект(без значения VALUE) для переобразования JSON

    public long id;
    public String title;

    public List<Object> values = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "TestMoreMini{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", values=" + values +
                '}';
    }
    public TestMoreMini(long id, String title, List<Object> meaningValuesTastaMore) {
        this.id = id;
        this.title = title;
        this.values = meaningValuesTastaMore;
    }
    public TestMoreMini() {

    }

}


class Test {                //основной объект на переобразование JSON (конечный)

    public long id;
    public String title;
    public String value;

    public static List<Object> meaningValuesTasta = new ArrayList<>();

    public void setValue() throws IOException, ParseException {



        List<Object> tastaList3 = new ArrayList<>();
        List<Object> tastaList4 = new ArrayList<>();
        List<Object> testMoreMinisObject = new ArrayList<>();

        JSONParser parser = new JSONParser();

      /*  Scanner scannerSystem = new Scanner(System.in);           //ПЕРЕДАЧА АРГУМЕНТА в ручную
        System.out.println("Укажите расположение файла tests.json :  ");
        String argumentOne = scannerSystem.nextLine();

        JSONObject objectValues = (JSONObject) parser.parse(new FileReader(argumentOne));
        JSONArray testsJSONArray = (JSONArray) objectValues.get("tests");*/
        //C:\Users\Владислав\IdeaProjects\PerformanceLab\src\main\java\task3\tests.json

            //аргумент для тестирования
//        JSONObject objectValues = (JSONObject) parser.parse(new FileReader("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\tests.json"));
//        JSONArray testsJSONArray = (JSONArray) objectValues.get("tests");

        String argumentTwo = Task3.argumentTwo;
        JSONObject objectValues = (JSONObject) parser.parse(new FileReader(argumentTwo));
        JSONArray testsJSONArray = (JSONArray) objectValues.get("tests");


//        ObjectMapper mapper = new ObjectMapper();                 //в текст
//        String json = mapper.writeValueAsString(objectValues);


        for (Object c : testsJSONArray) {                       //первый проход
            JSONObject jsonObjectValues = (JSONObject) c;


            long id12 = (long) jsonObjectValues.get("id");
//                System.out.println(id12);

            String title = (String) jsonObjectValues.get("title");

            String value = (String) jsonObjectValues.get("value");
//                System.out.println(value);


            //------------------второй заход   начало

            JSONArray values = (JSONArray) jsonObjectValues.get("values");               //второй проход
            List<Object> tastaList = new ArrayList<>();
//            System.out.println(values);
            if( values !=  null) {

                for (Object c1 : values) {
                    JSONObject jsonObjectValues1 = (JSONObject) c1;


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
                                tastaList3.add(valuesJSON);         //TUT 1
//                                testMoreMinis.add(valuesJSON);
//                                System.out.println(valuesJSON);
                                testMoreMinisObject.add(valuesJSON);

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
//        System.out.println(tastaStart);          //   РЕЗУЛЬТАТ
//        meaningValuesTasta.add(tastaStart);
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

    public static List<Object> getMeaningValuesTasta() {
        return meaningValuesTasta;
    }

    public static void setMeaningValuesTasta(List<Object> meaningValuesTasta) {
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
