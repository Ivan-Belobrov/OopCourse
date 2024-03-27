package ru.academits.belobrov.array_list_main;

import ru.academits.belobrov.array_list.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(5);

        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
        list.add("C++");
        list.add("Kotlin");

        ArrayList<String> listFirst = new ArrayList<>(5);

        listFirst.add("JavaScript");
        listFirst.add("C#");
        listFirst.add("PHP");
        listFirst.add("Java");
        listFirst.add("Ruby");

        System.out.println("Размер списка = " + list.size());

        System.out.println("Списко содержит Python: " + list.contains("Python"));
        System.out.println("Список содержит PHP: " + list.contains("PHP"));

        System.out.println("Элемент с индексом 3: " + list.get(3));

        list.set(1, "PHP");

        list.retainAll(listFirst);
        System.out.print("Элементы списка после сравнения и удаления не равных элементов: ");

        for (String element : list){
            System.out.print(" " + element);
        }

        System.out.println();

        list.remove(0);
        System.out.print("Элементы списка после удаления элемента: ");

        for (String element : list){
            System.out.print(" " + element);
        }

        list.clear();
    }
}