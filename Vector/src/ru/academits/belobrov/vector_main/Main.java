package ru.academits.belobrov.vector_main;

import ru.academits.belobrov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3);
        Vector vector2 = new Vector(new double[]{1, 2, 3});
        Vector vector3 = new Vector(3, new double[]{4, 5, 4});

        System.out.println("Размерность вектора vector1: " + vector1.getSize());
        System.out.println("Вектор vector2: " + vector2);
        System.out.println("Вектор vector3: " + vector3);
        System.out.println();

        vector1.add(vector2);
        System.out.println("vector1 + vector2 = " + vector1);
        System.out.println();

        vector3.multiplyByScalar(2);
        System.out.println("vector3 * 2 = " + vector3);
        System.out.println();

        Vector vector6 = new Vector(vector2);
        System.out.println("Копировынный вектор = " + vector6);
        System.out.println();

        vector1.reverse();
        System.out.println("Разворот вектора vector1 = " + vector1);
        System.out.println();

        System.out.println("Длина вектора vector2 = " + vector2.getLength());
        System.out.println();

        System.out.println("Компонента вектора vector3 с индексом 1: " + vector3.getComponent(1));
        vector3.setComponent(1, 6);
        System.out.println("Измененная компонента вектора vector3 с индексом 1: " + vector3.getComponent(1));
        System.out.println();

        System.out.println("vector1 равен vector2? " + vector1.equals(vector2));
        System.out.println();

        Vector vector4 = Vector.getSum(vector2, vector3);
        System.out.println("vector2 + vector3 = " + vector4);
        System.out.println();

        Vector vector5 = Vector.getDifference(vector3, vector2);
        System.out.println("vector3 - vector2 = " + vector5);
        System.out.println();

        double dotProduct = Vector.getDotProduct(vector2, vector3);
        System.out.println("Скалярное произведение вектора vector2 и vector3: " + dotProduct);

        vector2.subtract(vector3);
        System.out.println("vector2 - vector3 = " + vector2);
        System.out.println();
    }
}