package task3;

import java.util.ArrayList;
import java.util.List;

public class TastaStart extends Test {

    public List<Test> tests = new ArrayList<>();

    public TastaStart() {
    }


    public TastaStart(List<Test> tasta) {
        this.tests = tasta;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }



    @Override
    public String toString() {
        return "TastaStart{" +
                "tests=" + tests +
                '}';
    }
}
