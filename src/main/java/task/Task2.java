package task;


import java.awt.geom.Point2D;
import java.io.IOException;


public class Task2 {

    public static void main(String[] args) throws IOException {

//        Point2D point2D = new Point2D.Double(1,1);
//        System.out.println(point2D);
//        double radius2D = 5;
//        System.out.println(radius2D);
//        Point2D point222D = new Point2D.Double(6,6);
//        System.out.println(point222D);
//
//
//        System.out.println(point2D.getX() + " " + point2D.getY());
//        System.out.println(point222D.getX() + " " + point222D.getY());
//        System.out.println(radius2D);
//
//        double distance2D = Math.sqrt((point2D.getX()-point222D.getX())*(point2D.getX()-point222D.getX()) + (point2D.getY()-point222D.getY())*(point2D.getY()-point222D.getY()));
//        System.out.println(distance2D);
//
//        if (radius2D == distance2D){
//            System.out.println("0");
//        } else {
//            if(radius2D>distance2D){
//                System.out.println("1");
//            } else {
//                System.out.println("2");
//            }
//        }
//
//        System.out.println("-------------------");

//        Circle circle = new Circle();
//        System.out.println(circle);
//        Points points = new Points();
//        System.out.println(points);
//
//        System.out.println(circle.centre.getX() + " " + circle.centre.getY());
//        System.out.println(points.point2D.getX() + " " + points.point2D.getY());
//        System.out.println(circle.radius);
//
//
//        double distance2DD = Math.sqrt((circle.centre.getX()-points.point2D.getX())*(circle.centre.getX()-points.point2D.getX()) + (circle.centre.getY()-points.point2D.getY())*(circle.centre.getY()-points.point2D.getY()));
//        System.out.println(distance2DD);
//
//        if (circle.radius == distance2DD){
//            System.out.println("0");
//        } else {
//            if(circle.radius>distance2DD){
//                System.out.println("1");
//            } else {
//                System.out.println("2");
//            }
//        }
        //        System.out.println("-------------------");


        Circle circle = new Circle();
        circle.setCentre();
//        System.out.println(circle);
        Points points = new Points();
//        System.out.println(points);

//        System.out.println(circle.centre.getX() + " " + circle.centre.getY());
//        System.out.println(Arrays.stream(points.point2Ds).findAny().get().getX() + " " + Arrays.stream(points.point2Ds).findAny().get().getY());
//        System.out.println(Arrays.stream(points.point2Ds).collect(Collectors.toList()) + " " + Arrays.stream(points.point2Ds).findAny().get().getY());
//
//        System.out.println(circle.radius);


        for (Point2D a : points.point2Ds){

            double distance2DD = Math.sqrt((circle.centre.getX()-a.getX())*(circle.centre.getX()-a.getX()) + (circle.centre.getY()-a.getY())*(circle.centre.getY()-a.getY()));
//            System.out.println(distance2DD);

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




//        double distance2DD = Math.sqrt((circle.centre.getX()-points.point2D.getX())*(circle.centre.getX()-points.point2D.getX()) + (circle.centre.getY()-points.point2D.getY())*(circle.centre.getY()-points.point2D.getY()));
//        System.out.println(distance2DD);
//
//        if (circle.radius == distance2DD){
//            System.out.println("0");
//        } else {
//            if(circle.radius>distance2DD){
//                System.out.println("1");
//            } else {
//                System.out.println("2");
//            }
//        }








    }




    }
