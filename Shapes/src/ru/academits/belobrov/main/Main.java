package ru.academits.belobrov.main;

import ru.academits.belobrov.comparator.AreaShapesComparator;
import ru.academits.belobrov.comparator.PerimeterShapesComparator;
import ru.academits.belobrov.shapes.*;

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

        Arrays.sort(shapes, new AreaShapesComparator().reversed());
        Shape maxAreaShape = shapes[shapes.length - 1];
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape);

        Arrays.sort(shapes, new PerimeterShapesComparator());
        Shape largestPerimeterShape = shapes[0];
        Shape secondLargestPerimeterShape = null;

        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getPerimeter() > largestPerimeterShape.getPerimeter()) {
                secondLargestPerimeterShape = largestPerimeterShape;
                largestPerimeterShape = shapes[i];
            } else if (secondLargestPerimeterShape == null || shapes[i].getPerimeter() > secondLargestPerimeterShape.getPerimeter()) {
                secondLargestPerimeterShape = shapes[i];
            }
        }

        System.out.println("Фигура со вторым по величине периметром: " + secondLargestPerimeterShape);
    }
}