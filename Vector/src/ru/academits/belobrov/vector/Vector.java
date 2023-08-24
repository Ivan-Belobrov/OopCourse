package ru.academits.belobrov.vector;

import java.util.Arrays;
import java.util.Objects;

public class Vector {
    private final double[] components;
    private final int size;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("–азмерность вектора должна быть положительным числом");
        }

        this.size = n;
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.size = vector.size;
        this.components = vector.components.clone();
    }

    public Vector(double[] values) {
        this.size = values.length;
        this.components = new double[this.size];
        System.arraycopy(values, 0, this.components, 0, this.size);
    }

    public Vector(int n, double[] values) {
        this.size = n;
        this.components = new double[n];
        int copyLength = Math.min(n, values.length);

        System.arraycopy(values, 0, this.components, 0, copyLength);
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            sb.append(components[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public void add(Vector vector) {
        if (size != vector.size) {
            throw new IllegalArgumentException("–азмерности вектора должны бать одинаковыми");
        }

        for (int i = 0; i < size; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (size != vector.size) {
            throw new IllegalArgumentException("–азмерности вектора должны бать одинаковыми");
        }

        for (int i = 0; i < size; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < size; i++) {
            components[i] *= scalar;
        }
    }

    public void revers() {
        multiplyByScalar(-1);
    }

    public double getMagnitude() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("»ндекс компонента вектора выходит за пределы размерности");
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("»ндекс компонента вектора выходит за пределы размерности");
        }

        components[index] = value;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null || getClass()!= obj.getClass()){
            return false;
        }

        Vector vector = (Vector) obj;
        if (size!= vector.size){
            return false;
        }

        for (int i = 0; i < size; i++){
            if (components[i] != vector.components[i]){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode(){
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(components);

        return result;
    }

    public static Vector add(Vector vector1, Vector vector2){
        int maxSize = Math.max(vector1.size, vector2.size);
        int minSize = Math.min(vector1.size, vector2.size);
        double[] resultComponents = new double[maxSize];

        System.arraycopy(vector1.components, 0, resultComponents, 0, vector1.size);

        for (int i = 0; i < minSize; i++){
            resultComponents[i] += vector2.components[i];
        }

        return new Vector(maxSize, resultComponents);
    }

    public static Vector subtract(Vector vector1, Vector vector2){
        int maxSize = Math.max(vector1.size, vector2.size);
        int minSize = Math.min(vector1.size, vector2.size);
        double[] resultComponents = new double[maxSize];

        System.arraycopy(vector1.components, 0, resultComponents, 0, vector1.size);

        for (int i = 0; i < minSize; i++){
            resultComponents[i] -= vector2.components[i];
        }

        return new Vector(maxSize, resultComponents);
    }

    public static double dotProduct(Vector vector1, Vector vector2){
        int maxSize = Math.max(vector1.size, vector2.size);
        int minSize = Math.min(vector1.size, vector2.size);
        double result = 0;

        for (int i = 0; i < minSize; i++){
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}