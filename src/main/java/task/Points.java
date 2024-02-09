package task;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

public class Points {

    Point2D[] point2Ds;
    Point2D point2D;

    public Points() {
        Point2D p1 = new Point2D.Double (2, 3);
        Point2D p2 = new Point2D.Double(8, 4.3);
        point2Ds = new Point2D.Double[]{(Point2D.Double) p1, (Point2D.Double) p2};
        point2D = new Point2D.Double(6, 6);
    }

    @Override
    public String toString() {
        return "Points{" +
                "point2Ds=" + Arrays.toString(point2Ds) +
                ", point2D=" + point2D +
                '}';
    }
}
