package ru.academits.belobrov.shape.belobrov.belobrov.rectangle;

import ru.academits.belobrov.shape.belobrov.belobrov.shape.Shape;

import java.util.Objects;

public class Rectangle implements Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double hastCode() {

        return Objects.hash(length, width);
    }

    @Override
    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }

        if (objects == null || getClass() != objects.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) objects;
        return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public String toString() {
        return "Прямоугольник с длиной = " + length + "шириной = " + width;
    }
}