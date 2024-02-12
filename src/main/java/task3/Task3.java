package task3;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.ParseException;

public class Task3 {


    public static void main(String[] args) throws IOException, ParseException {

        Values values = new Values();
        values.setValue();
        ValuesArray valuesArray = new ValuesArray(values.getMeaningValuesValues());
//        System.out.println( "ALL1 " + valuesArray);

        Test test = new Test();
        test.setValue();
        TastaStart tastaStart = new TastaStart(test.getMeaningValuesTasta());
//        System.out.println( "ALL2 " + tastaStart);






//        System.out.println( "&&& " + valuesArray.getValuesList().get(3).getId());
//        System.out.println( "&&& " + valuesArray.getValuesList().get(3).getValue());
//        System.out.println("&&& "+tastaStart.getTests().get(3).getId());
//        System.out.println("&&& "+tastaStart.getTests().get(3).getValue());
//        System.out.println("***"+tastaStart.getTests().get(3).toString());

        //----цыкл

        for(int x=0; x<valuesArray.getValuesList().size();x++){                         //чтение Values
//            System.out.println( "id values " + valuesArray.getValuesList().get(x).getId());

            for(int y=0; y<tastaStart.getTests().size();y++){
                if((Objects.equals(valuesArray.getValuesList().get(x).getId(), tastaStart.getTests().get(y).getId()) == true)){
//                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    tastaStart.getTests().get(y).setValue(valuesArray.getValuesList().get(x).getValue());

                }
//                System.out.println("&&& "+tastaStart.getTests().get(y).getId());

//                System.out.println(Objects.equals(valuesArray.getValuesList().get(x).getValue(), tastaStart.getTests().get(y).getValue()));

            }

        }
        System.out.println( "***********************");
        System.out.println( tastaStart);


//        for(int x=0; x<tastaStart.getTests().size();x++){                         //чтение Values
//            System.out.println( "id tastaStart " + tastaStart.getTests().get(x).getId());
//        }
            Report report = new Report();
            report.valuesToJSON(tastaStart);


        //--





    }
}



