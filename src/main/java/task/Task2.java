package task;


import java.awt.geom.Point2D;
import java.io.IOException;


public class Task2 {

    public static void main(String[] args) throws IOException {

// пример пути к файлу C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\points.txt

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
