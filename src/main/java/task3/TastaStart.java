package task3;

import java.util.ArrayList;
import java.util.List;

public class TastaStart {

    public List<Tasta> tasta = new ArrayList<>();

    public TastaStart() {
    }


    public TastaStart(List<Tasta> tasta) {
        this.tasta = tasta;
    }

    public List<Tasta> getTasta() {
        return tasta;
    }

    public void setTasta(List<Tasta> tasta) {
        this.tasta = tasta;
    }

    @Override
    public String toString() {
        return "TastaStart{" +
                "tasta=" + tasta +
                '}';
    }
}
