<<<<<<< HEAD:Shapes/src/ru/academits/belobrov/main/Main.java
package Shapes.src.ru.academits.belobrov.main;

import ru.academits.belobrov.comparator.AreaShapesComparator;
import ru.academits.belobrov.comparator.PerimeterShapesComparator;

=======
package ru.academits.belobrov.shapes.shapes_main;

import ru.academits.belobrov.shapes.*;
import ru.academits.belobrov.shapes.shapes_comparator.ShapeAreaComparator;
import ru.academits.belobrov.shapes.shapes_comparator.ShapePerimeterComparator;
>>>>>>> 9351c32a08391e5cf670d74d07170d6c8a87c413:Shapes/src/ru/academits/belobrov/shapes/shapes_main/Main.java

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ru.academits.belobrov.shapes.Shape[] shapes = {
                new Square(10),
                new Triangle(2, 3, 5, 6, 4, 8),
                new Rectangle(5, 7),
                new Circle(10),
                new Square(8),
                new Triangle(10, 2, 7, 4, 20, 3),
                new Rectangle(21, 13),
                new Circle(21),
                new Square(14)
        };

        Arrays.sort(shapes, new ShapeAreaComparator());
        Shape maxAreaShape = shapes[shapes.length - 1];
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape);

        Arrays.sort(shapes, new ShapePerimeterComparator());
        Shape maxPerimeterShape = shapes[shapes.length - 1];
        Shape secondLargestPerimeterShape = null;

        for (int i = shapes.length - 2; i >= 0; i--) {
            if (shapes[i].getPerimeter() < maxPerimeterShape.getPerimeter()) {
                secondLargestPerimeterShape = shapes[i];
                break;
            }
        }

        System.out.println("Фигура со вторым по величине периметром: " + secondLargestPerimeterShape);
    }
}