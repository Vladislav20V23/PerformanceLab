package task3;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static task3.Values.meaningValuesValues;

public class Report {


    public void valuesToJSON() throws IOException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


//        String json = ow.writeValueAsString(meaningValuesValues.get(0));
//        System.out.println(json);
                String json = ow.writeValueAsString(meaningValuesValues);

        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\Myreport.json"));
        bw.append(json);
        bw.close();

    }

    public static void main(String[] args) throws IOException, ParseException {







    }


}
