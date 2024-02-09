package task;


import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Points {

    Point2D[] point2Ds;
    Point2D point2D;

    public Points() {
//        Point2D p1 = new Point2D.Double (0, 0);
//        Point2D p2 = new Point2D.Double(1, 6);
//        Point2D p3 = new Point2D.Double(6, 6);
//        point2Ds = new Point2D.Double[]{(Point2D.Double) p1, (Point2D.Double) p2, (Point2D.Double) p3};
//        point2D = new Point2D.Double(0, 0);
    }


    public void addPoint2D(){
        new Point2D.Double(4,3);
    }
    public void setPoint2Ds() throws IOException {

        Scanner scanner = new Scanner(new File("C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\points.txt"));

        List<Double> array = new ArrayList<>();

        while (scanner.hasNextDouble()){
            array.add(scanner.nextDouble());
        }

        List<Double> arrayX= new ArrayList<>();
        List<Double> arrayY= new ArrayList<>();





        System.out.println(array);


        int x = 2;
        for(double a : array){
            if(x%2>0) {
                arrayY.add(a);
            } else {
                arrayX.add(a);
                }
            x++;
        }

        System.out.println(arrayX);
        System.out.println(arrayY);



    }

    public static void main(String[] args) throws IOException {
    Points a = new Points();
    a.setPoint2Ds();

    }



        @Override
    public String toString() {
        return "Points{" +
                "point2Ds=" + Arrays.toString(point2Ds) +
                ", point2D=" + point2D +
                '}';
    }

}
