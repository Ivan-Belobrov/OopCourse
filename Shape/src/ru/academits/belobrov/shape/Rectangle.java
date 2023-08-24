package ru.academits.belobrov.shape;

import java.util.Objects;

public class Rectangle implements Shape {
    private final double height;
    private final double width;

    public Rectangle(double length, double width) {
        this.height = length;
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
        int result = 25;
        long heightBits = Double.doubleToLongBits(height);
        long widthBits = Double.doubleToLongBits(width);

        result = 31 * result + (int) (heightBits ^ (heightBits >>> 32));
        result = 31 * result + (int) (widthBits ^ (widthBits >>> 32));

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
        return "Прямоугольник с длиной = " + height + "шириной = " + width;
    }
}