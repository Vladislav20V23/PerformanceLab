package task;



import java.awt.geom.Point2D;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Circle {

    Point2D centre;
    double radius;

      Circle() {
//        centre = new Point2D.Double(1,1);
//        radius = 5;
    }

    public void getCentre() throws IOException {

        Scanner scanner = new Scanner(new File("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\circle.txt"));

        List<Double> array = new ArrayList<>();

        while (scanner.hasNextDouble()){
            array.add(scanner.nextDouble());
        }

//        System.out.println(array);


        centre = new Point2D.Double(array.get(0),array.get(1));
        radius = array.get(2);


//        System.out.println(centre);
//        System.out.println(radius);


    }

    public static void main(String[] args) throws IOException {

        Circle a = new Circle();
        a.getCentre();


    }


        @Override
    public String toString() {
        return "Сircle{" +
                "centre=" + centre +
                ", radius=" + radius +
                '}';
    }
}
