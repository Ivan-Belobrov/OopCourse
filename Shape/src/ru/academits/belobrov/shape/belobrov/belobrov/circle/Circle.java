package ru.academits.belobrov.shape.belobrov.belobrov.circle;

import ru.academits.belobrov.shape.belobrov.belobrov.shape.Shape;

import java.util.Objects;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double hastCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }

        if (objects == null || getClass() != objects.getClass()) {
            return false;
        }

        Circle other = (Circle) objects;
        return Objects.equals(other.radius, radius) && radius == other.radius;
    }

    @Override
    public String toString() {
        return "Круг с радиусом " + radius;
    }
}