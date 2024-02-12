package task3;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static task3.Test.meaningValuesTasta;

public class Report {


    public void valuesToJSON(TastaStart tastaStart) throws IOException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


//        String json = ow.writeValueAsString(meaningValuesValues.get(0));      // список всех Values в виде String
//        System.out.println(json);
                String json = ow.writeValueAsString(tastaStart);     //!!!!

        Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Укажите расположение файла report.json :  ");
        String argumentOne = scannerSystem.nextLine();


        BufferedWriter bw=new BufferedWriter(new FileWriter(argumentOne));
        bw.append(json);
        bw.close();

    }

    public static void main(String[] args) throws IOException, ParseException {



    }


}
