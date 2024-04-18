package ru.academits.belobrov.array_list_main;

import ru.academits.belobrov.array_list.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(5);

        list1.add("Java");
        list1.add("Python");
        list1.add("JavaScript");
        list1.add("C++");
        list1.add("Kotlin");

        ArrayList<String> list2 = new ArrayList<>(5);

        list2.add("JavaScript");
        list2.add("C#");
        list2.add("PHP");
        list2.add("Java");
        list2.add("Ruby");

        System.out.println("Размер списка = " + list1.size());

        System.out.println("Список содержит Python: " + list1.contains("Python"));
        System.out.println("Список содержит PHP: " + list1.contains("PHP"));

        System.out.println("Элемент с индексом 3: " + list1.get(3));

        list1.set(1, "PHP");

        list1.retainAll(list2);
        System.out.print("Элементы списка после сравнения и удаления не равных элементов: ");
        System.out.print(list1);

        System.out.println();

        list1.remove(0);
        System.out.print("Элементы списка после удаления элемента: ");
        System.out.print(list1);

        list1.clear();
    }
}