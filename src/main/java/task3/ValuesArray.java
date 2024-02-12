package task3;

import java.util.ArrayList;
import java.util.List;

public class ValuesArray extends Values{
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
