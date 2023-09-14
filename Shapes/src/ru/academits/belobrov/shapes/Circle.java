package ru.academits.belobrov.shapes;

public class Circle implements Shape {
    private final double radius;

    private static final int hashMultiplier = 31;

    public Circle(double radius) {

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
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
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int hashCode() {
        int result = 25;
        int radiusHash = Double.hashCode(radius);
        result = hashMultiplier * result + radiusHash;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Circle circle = (Circle) obj;
        return radius == circle.radius;
    }

    @Override
    public String toString() {
        return "Круг с радиусом " + radius;
    }
}