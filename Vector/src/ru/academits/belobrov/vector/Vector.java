package ru.academits.belobrov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом. " +
                    "Переданный размер: " + size);
        }

        components = new double[size];
    }

    public Vector(double[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть равен 0.");
        }

        components = Arrays.copyOf(values, values.length);
    }

    public Vector(int size, double[] values) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом. " +
                    "Переданный размер: " + size);
        }

        components = Arrays.copyOf(values, size);
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < components.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }

            sb.append(components[i]);
        }

        sb.append("}");
        return sb.toString();
    }

    public void add(Vector vector) {
        int maxLength = Math.max(components.length, vector.components.length);

        if (maxLength > components.length) {
            components = Arrays.copyOf(components, maxLength);
        }

        for (int i = 0; i < maxLength; i++) {
            if (i < vector.components.length) {
                components[i] += vector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        int maxLength = Math.max(components.length, vector.components.length);

        if (maxLength > components.length) {
            components = Arrays.copyOf(components, maxLength);
        }

        for (int i = 0; i < maxLength; i++) {
            if (i < vector.components.length) {
                components[i] -= vector.components[i];
            }
        }
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
            throw new IndexOutOfBoundsException("Индекс компонента вектора " + index
                    + " выходит за пределы размерности [0, " + (components.length - 1) + "]");
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс компонента вектора " + index
                    + " выходит за пределы размерности [0, " + (components.length - 1) + "]");
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
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.add(vector2);

        return result;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.subtract(vector2);

        return result;
    }

    public static double getDotProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.components.length, vector2.components.length);
        double result = 0;

        for (int i = 0; i < minSize; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}