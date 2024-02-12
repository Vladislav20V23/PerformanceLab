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


        Test test = new Test();
        test.setValue();
        TastaStart tastaStart = new TastaStart(test.getMeaningValuesTasta());


        System.out.println( "&&& " + valuesArray.getValuesList().get(3).getId());
        System.out.println( "&&& " + valuesArray.getValuesList().get(3).getValue());
        System.out.println("&&& "+tastaStart.getTests().get(3).getId());
        System.out.println("&&& "+tastaStart.getTests().get(3).getValue());

       System.out.println(Objects.equals(valuesArray.getValuesList().get(1).getValue(), tastaStart.getTests().get(1).getValue()));
//
//       int x = 0;
//       int y = 0;
//       for (Values v: values.getMeaningValuesValues()){
//           System.out.println( "&&& " + valuesArray.getValuesList().get(x).getId());
//           System.out.println( "&&& " + valuesArray.getValuesList().get(x).getValue());
//           System.out.println( "--------------------- ");
//           System.out.println("&&& "+tastaStart.getTests().get(y).getId());
//           System.out.println("&&& "+tastaStart.getTests().get(y).getValue());
//           System.out.println( "--------------------- ");
//
//           x++;
//
//       }



    }


}
