package ru.academits.belobrov.shape.belobrov.belobrov.shape.main.belobrov;

import ru.academits.belobrov.shape.belobrov.belobrov.circle.Circle;
import ru.academits.belobrov.shape.belobrov.belobrov.rectangle.Rectangle;
import ru.academits.belobrov.shape.belobrov.belobrov.triangle.Triangle;
import ru.academits.belobrov.shape.belobrov.belobrov.shape.Shape;
import ru.academits.belobrov.shape.belobrov.belobrov.square.Square;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];

        shapes[0] = new Square(10);
        shapes[1] = new Triangle(2, 3, 5, 6, 4, 8);
        shapes[2] = new Rectangle(5, 7);
        shapes[3] = new Circle(10);
        shapes[4] = new Square(8);
        shapes[5] = new Triangle(10, 2, 7, 4, 20, 3);
        shapes[6] = new Rectangle(7, 13);
        shapes[7] = new Circle(21);
        shapes[8] = new Square(18);

        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getArea).reversed());
        Shape maxAreaShape = shapes[0];
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape.toString());

        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getPerimeter));
        Shape secondLargestPerimeterShape = shapes[7];
        System.out.println("Фигура со вторым по величине периметром: " + secondLargestPerimeterShape.toString());
    }
}