package ru.academits.belobrov.vector;

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

        vector1.revers();
        System.out.println("Разворот вектора vector1 = " + vector1);
        System.out.println();

        System.out.println("Длина вектора vector2 = " + vector2.getMagnitude());
        System.out.println();

        System.out.println("Клмпонента вектора vector3 с индексом 1: " + vector3.getComponent(1));
        vector3.setComponent(1, 6);
        System.out.println("Измененная компонента вектора vector3 с индексом 1: " + vector3.getComponent(1));
        System.out.println();

        System.out.println("vector1 равен vector2? " + vector1.equals(vector2));
        System.out.println();

        Vector vector4 = Vector.add(vector2, vector3);
        System.out.println("vector2 + vector3 = " + vector4);
        System.out.println();

        Vector vector5 = Vector.subtract(vector3, vector2);
        System.out.println("vector3 - vector2 = " + vector5);
        System.out.println();

        double dotProduct = Vector.dotProduct(vector2, vector3);
        System.out.println("Скалярное произведение вектора vector2 и vector3: " + dotProduct);

        vector2.subtract(vector3);
        System.out.println("vector2 - vector3 = " + vector2);
        System.out.println();
    }
}