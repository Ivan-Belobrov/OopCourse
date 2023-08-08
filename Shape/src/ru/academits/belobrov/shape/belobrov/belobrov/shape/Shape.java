package ru.academits.belobrov.shape.belobrov.belobrov.shape;

public interface Shape {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();
    String toString();

    double hastCode();
    boolean equals(Object objects);
}