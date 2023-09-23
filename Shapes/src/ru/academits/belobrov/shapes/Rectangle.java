package ru.academits.belobrov.shapes;

public class Rectangle implements Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public int hashCode() {
        final int hashMultiplier = 31;
        int result = 25;

        result = hashMultiplier * result + Double.hashCode(height);
        result = hashMultiplier * result + Double.hashCode(width);

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

        Rectangle rectangle = (Rectangle) obj;
        return rectangle.height == height && rectangle.width == width;
    }

    @Override
    public String toString() {
        return "Прямоугольник с высотой  = " + height + " шириной = " + width;
    }
}