package task3;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Task3 {





    public static void main(String[] args) {

        Values valuesObj = new Values();
        valuesObj.value = "passed";
        valuesObj.id = 2;

        List<String> listOfStates = new ArrayList<String>();
        listOfStates.add("passed");
        listOfStates.add("passed");
        listOfStates.add("failed");

        valuesObj.listString = listOfStates;
        ObjectMapper mapper = new ObjectMapper();

        try {

            // Writing to a file
            mapper.writeValue(new File("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task3\\report.json"), valuesObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
