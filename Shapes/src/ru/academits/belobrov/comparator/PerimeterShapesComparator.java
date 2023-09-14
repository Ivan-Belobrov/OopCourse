package ru.academits.belobrov.comparator;

import ru.academits.belobrov.shapes.Shape;

import java.util.Comparator;

public class PerimeterShapesComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
       return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}