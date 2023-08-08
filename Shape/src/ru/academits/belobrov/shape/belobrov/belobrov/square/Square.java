package ru.academits.belobrov.shape.belobrov.belobrov.square;

import ru.academits.belobrov.shape.belobrov.belobrov.shape.Shape;

import java.util.Objects;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double hastCode() {
        return Objects.hash(side);
    }

    @Override
    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }

        if (objects == null || getClass() != objects.getClass()) {
            return false;
        }

        Square square = (Square) objects;
        return Double.compare(square.side,side) == 0;
    }

    @Override
    public String toString(){
        return " вадрат со стороной " + side;
    }
}