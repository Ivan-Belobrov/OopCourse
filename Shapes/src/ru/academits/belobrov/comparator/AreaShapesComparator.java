package ru.academits.belobrov.comparator;

import ru.academits.belobrov.shapes.Shape;

import java.util.Comparator;

public class AreaShapesComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double area1 = shape1.getArea();
        double area2 = shape2.getArea();

        return Double.compare(area2, area1);
    }
}