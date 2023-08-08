package ru.academits.belobrov.shape.belobrov.belobrov.triangle;

import ru.academits.belobrov.shape.belobrov.belobrov.shape.Shape;

import java.util.Objects;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getArea() {
        return 0.5 * getWidth() * getHeight();
    }

    @Override
    public double getPerimeter() {
        double side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Треугольник с координатами (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")";
    }

    @Override
    public double hastCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
    }

    @Override
    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }

        if (objects == null || getClass() != objects.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) objects;
        return Double.compare(triangle.x1, x1) == 0 && Double.compare(triangle.y1, y1) == 0 &&
                Double.compare(triangle.x2, x2) == 0 && Double.compare(triangle.y2, y2) == 0 &&
                Double.compare(triangle.x3, x3) == 0 && Double.compare(triangle.y3, y3) == 0;
    }
}