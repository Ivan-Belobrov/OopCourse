package ru.academits.belobrov.shapes.shapes_main;

import ru.academits.belobrov.shapes.*;
import ru.academits.belobrov.shapes.shapes_comparator.AreaShapeComparator;
import ru.academits.belobrov.shapes.shapes_comparator.PerimeterShapeComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(10),
                new Triangle(2, 3, 5, 6, 4, 8),
                new Rectangle(5, 7),
                new Circle(10),
                new Square(8),
                new Triangle(10, 2, 7, 4, 20, 3),
                new Rectangle(7, 13),
                new Circle(21),
                new Square(18)
        };

        Arrays.sort(shapes, new AreaShapeComparator().reversed());
        Shape maxAreaShape = shapes[shapes.length - 1];
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape);

        Arrays.sort(shapes, new PerimeterShapeComparator());
        Shape maxPerimeterShape = shapes[shapes.length - 1];
        Shape secondLargestPerimeterShape = null;

        for (int i = shapes.length - 2; i >=0; i--) {
            if (shapes[i].getPerimeter() < maxPerimeterShape.getPerimeter()) {
                secondLargestPerimeterShape = shapes[i];
                break;
            }
        }

        System.out.println("Фигура со вторым по величине периметром: " + secondLargestPerimeterShape);
    }
}