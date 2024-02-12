package task3;

import java.util.ArrayList;
import java.util.List;

public class TestMoreMini extends Test{

    public long id;
    public String title;

    public List<Test> values = new ArrayList<>();

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
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
    public TestMoreMini(long id, String title, List<Test> meaningValuesTastaMore) {
        this.id = id;
        this.title = title;
        this.values = meaningValuesTastaMore;
    }
    public TestMoreMini() {

    }

}
