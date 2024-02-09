package task;



import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Circle {

    Point2D centre;
    double radius;

      Circle() { }

    public void setCentre() throws IOException {


        Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Укажите расположение файла с координатами и радиусом окружности:  ");
        String argumentOne = scannerSystem.nextLine();


        Scanner scanner = new Scanner(new File(argumentOne));
//        C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\circle.txt

        List<Double> array = new ArrayList<>();

        while (scanner.hasNextDouble()){
            array.add(scanner.nextDouble());
        }

        centre = new Point2D.Double(array.get(0),array.get(1));
        radius = array.get(2);
   }


        @Override
    public String toString() {
        return "Сircle{" +
                "centre=" + centre +
                ", radius=" + radius +
                '}';
    }
}
