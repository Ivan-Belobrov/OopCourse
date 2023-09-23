package ru.academits.belobrov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом");
        }

        components = new double[size];
    }

    public Vector(double[] values) {
        components = Arrays.copyOf(values, values.length);
    }

    public Vector(int size, double[] values) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом.");
        }

        components = Arrays.copyOf(values, size);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        if (components.length > 0) {
            sb.append(components[0]);

            for (int i = 1; i < components.length; i++) {
                sb.append(", ").append(components[i]);
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public void add(Vector vector) {
        int maxLength = Math.max(components.length, vector.components.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double component1 = i < components.length ? components[i] : 0;
            double component2 = i < vector.components.length ? vector.components[i] : 0;
            result[i] = component1 + component2;
        }

        components = result;
    }

    public void subtract(Vector vector) {
        int maxLength = Math.max(components.length, vector.components.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double component1 = i < components.length ? components[i] : 0;
            double component2 = i < vector.components.length ? vector.components[i] : 0;
            result[i] = component1 - component2;
        }

        components = result;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс компонента вектора выходит за пределы размерности");
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс компонента вектора выходит за пределы размерности");
        }

        components[index] = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        int result = components.length;
        result = 31 * result + Arrays.hashCode(components);

        return result;
    }

    public static Vector add(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.components.length, vector2.components.length);
        int minSize = Math.min(vector1.components.length, vector2.components.length);

        double[] resultComponents = new double[maxSize];

        System.arraycopy(vector1.components, 0, resultComponents, 0, vector1.components.length);

        for (int i = 0; i < minSize; i++) {
            resultComponents[i] += vector2.components[i];
        }

        return new Vector(maxSize, resultComponents);
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.components.length, vector2.components.length);
        int minSize = Math.min(vector1.components.length, vector2.components.length);

        double[] resultComponents = new double[maxSize];

        System.arraycopy(vector1.components, 0, resultComponents, 0, vector1.components.length);

        for (int i = 0; i < minSize; i++) {
            resultComponents[i] -= vector2.components[i];
        }

        return new Vector(maxSize, resultComponents);
    }

    public static double calculateDotProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.components.length, vector2.components.length);
        double result = 0;

        for (int i = 0; i < minSize; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}