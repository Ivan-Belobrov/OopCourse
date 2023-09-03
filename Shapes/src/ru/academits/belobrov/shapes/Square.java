package ru.academits.belobrov.shapes;

public class Square implements Shape {
    private final double sideLength;

    public Square(double side) {
        this.sideLength = side;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;

        temp = Double.doubleToLongBits(sideLength);
        result = prime * result + Double.hashCode(temp);

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

        Square square = (Square) obj;
        return square.sideLength == sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат со стороной " + sideLength;
    }
}