package ru.academits.belobrov.hash_table_main;

import ru.academits.belobrov.hash_table.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(10);

        hashTable.add("Яблоко");
        hashTable.add("Банан");
        hashTable.add("Вишня");
        hashTable.add("Персик");
        hashTable.add("Ягода");

        System.out.print("Перебор Элементов: ");
        System.out.println(hashTable);

        System.out.println("Размер: " + hashTable.size());
        System.out.println("Содержит 'Вишня' " + hashTable.contains("Вишня"));

        hashTable.remove("Вишня");
        System.out.println("Размер после удаления 'Вишня': " + hashTable.size());
        System.out.println("Содержит 'Вишня' " + hashTable.contains("Вишня"));

        hashTable.clear();
        System.out.print("Перебор Элементов: ");
        System.out.println(hashTable);
    }
}