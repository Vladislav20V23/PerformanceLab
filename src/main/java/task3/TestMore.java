package task3;

import java.util.ArrayList;
import java.util.List;

public class TestMore extends Test {

    public long id;
    public String title;
    public String value;

    public List<Test> values = new ArrayList<>();

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

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }

    public TestMore() {
    }

    public TestMore(long id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public TestMore(long id, String title, String value, List<Test> meaningValuesTastaMore) {
        this.id = id;
        this.title = title;
        this.value = value;
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
