package ru.academits.belobrov.shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double area1 = shape1.getArea();
        double area2 = shape2.getArea();

        if (area1 > area2) {
            return -1;
        } else if (area1 < area2) {
            return 1;
        }
        return 0;
    }
}
