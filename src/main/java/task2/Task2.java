package task2;


import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Task2 {
    static String argumentOne;
    static String argumentTwo;
    public static void main(String[] args) throws IOException {

// пример пути к файлу C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\points.txt

        argumentOne = args[0];      //считывает первый аргумент
        argumentTwo = args[1];      //считывает two аргумент



        Circle circle = new Circle();
        circle.setCentre();

        Points points = new Points();
        points.setPoint2Ds();


        for (Point2D a : points.point2Ds){

            double distance2DD = Math.sqrt((circle.centre.getX()-a.getX())*(circle.centre.getX()-a.getX()) + (circle.centre.getY()-a.getY())*(circle.centre.getY()-a.getY()));

            if (circle.radius == distance2DD){
                System.out.println("0");
            } else {
                if(circle.radius>distance2DD){
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }

        }

    }
}

class Circle {

    Point2D centre;
    double radius;

    Circle() { }

    public void setCentre() throws IOException {


       /* Scanner scannerSystem = new Scanner(System.in);           //для ручного ввода
        System.out.println("Укажите расположение файла с координатами и радиусом окружности:  ");
        String argumentOne = scannerSystem.nextLine();*/

        String argumentOne = Task2.argumentOne;



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

class Points {

    List<Point2D> point2Ds = new ArrayList<>();
    public Points() {    }


    public void setPoint2Ds() throws IOException {


      /*  Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Укажите расположение файла с координатами точек : ");
        String argumentTwo = scannerSystem.nextLine();*/

        String argumentTwo = Task2.argumentTwo;

        Scanner scanner = new Scanner(new File(argumentTwo));
//        C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\points.txt
//         C:\Users\Владислав\IdeaProjects\PerformanceLab\src\main\java\task2\circle.txt
        List<Double> array = new ArrayList<>();

        while (scanner.hasNextDouble()){
            array.add(scanner.nextDouble());
        }

        List<Double> arrayX= new ArrayList<>();
        List<Double> arrayY= new ArrayList<>();


        int x = 2;
        for(double a : array){
            if(x%2>0) {
                arrayY.add(a);
            } else {
                arrayX.add(a);
            }
            x++;
        }


        for (int i = 0; i<arrayX.size(); i++){
            Point2D point = new Point2D.Double(arrayX.get(i), arrayY.get(i));
            point2Ds.add(point);
        }

    }

}

