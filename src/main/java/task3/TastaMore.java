package task3;

import java.util.ArrayList;
import java.util.List;

public class TastaMore extends Tasta{

    public long id;
    public String title;
    public String value;

    public List<Tasta> meaningValuesTastaMore = new ArrayList<>();

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

    public List<Tasta> getMeaningValuesTastaMore() {
        return meaningValuesTastaMore;
    }

    public void setMeaningValuesTastaMore(List<Tasta> meaningValuesTastaMore) {
        this.meaningValuesTastaMore = meaningValuesTastaMore;
    }

    public TastaMore() {
    }

    public TastaMore(long id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public TastaMore(long id, String title, String value, List<Tasta> meaningValuesTastaMore) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.meaningValuesTastaMore = meaningValuesTastaMore;
    }

    @Override
    public String toString() {
        return "TastaMore{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", meaningValuesTastaMore=" + meaningValuesTastaMore +
                '}';
    }
}
