package task;

import java.awt.geom.Point2D;

public class Circle {

    Point2D centre;
    double radius;


    Circle() {
        centre = new Point2D.Double(1,1);
        radius = 5;
    }


    @Override
    public String toString() {
        return "Сircle{" +
                "centre=" + centre +
                ", radius=" + radius +
                '}';
    }
}
