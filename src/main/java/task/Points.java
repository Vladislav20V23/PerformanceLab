package task;


import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Points {

    List<Point2D> point2Ds = new ArrayList<>();
    public Points() {    }


    public void setPoint2Ds() throws IOException {

        Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Укажите расположение файла с координатами точек : ");
        String argumentTwo = scannerSystem.nextLine();

        Scanner scanner = new Scanner(new File(argumentTwo));
//        C:\\Users\\Владислав\\IdeaProjects\\PerformanceLab\\src\\main\\java\\task\\points.txt

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
