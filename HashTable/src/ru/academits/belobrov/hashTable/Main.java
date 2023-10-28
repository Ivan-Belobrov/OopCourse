package ru.academits.belobrov.hashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String> myHashTable = new MyHashTable<>(10);

        myHashTable.add("Яблоко");
        myHashTable.add("Банан");
        myHashTable.add("Вишня");
        myHashTable.add("Персик");
        myHashTable.add("Ягода");

        System.out.println("Размер: " + myHashTable.size());
        System.out.println("Содержит 'Вишня'" + myHashTable.contains("Вишня"));

        myHashTable.remove("Вишня");
        System.out.println("Размер после удаления 'Вишня': " + myHashTable.size());
        System.out.println("Содержит 'Вишня' " + myHashTable.contains("Вишня"));

        System.out.println("Перебор Элементов: ");
        for (String element : myHashTable) {
            System.out.println(element);
        }

        System.out.println("Список пустой: " + myHashTable.isEmpty());
    }
}
