package ru.academits.belobrov.arrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(5);

        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
        list.add("C++");
        list.add("Kotlin");

        System.out.println("Размер списка = " + list.size());

        System.out.println("Списко содержит Python: " + list.contains("Python"));
        System.out.println("Список содержит PHP: " + list.contains("PHP"));

        System.out.println("Элемент с индексом 3: " + list.get(3));

        list.set(1, "Hello");

        list.remove(2);

        System.out.println("Элементы списка:");
        for (String element : list){
            System.out.println(element);
        }

        list.clear();

        System.out.println("Список пуст: " + true);
    }
}