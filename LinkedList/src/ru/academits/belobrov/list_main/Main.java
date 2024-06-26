package ru.academits.belobrov.list_main;

import ru.academits.belobrov.list.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(12);
        list.insertFirst(13);
        list.insertFirst(10);
        list.insertFirst(25);
        list.insertFirst(17);
        list.insertFirst(4);

        System.out.print("Список элементов: ");
        System.out.println(list);

        System.out.println("Размер списка: " + list.getSize());

        System.out.println("Первый элемент списка: " + list.getFirst());

        System.out.println("Элемент по индексу 1: " + list.getByIndex(1));

        list.setByIndex(1, 2);
        System.out.println("Измененный элемент по индексу 1: " + list.getByIndex(1));

        int removedElement = list.removeAtIndex(9);
        System.out.println("Удаленный Элемент: " + removedElement);

        System.out.print("Список после удаления элемента: ");
        System.out.println(list);

        list.insert(9, 18);
        list.insert(2, 6);
        System.out.print("Список после добавления элементов: ");
        System.out.println(list);

        list.removeAtIndex(2);
        System.out.print("Список после удаление элемента по индексу 2: ");
        System.out.println(list);

        LinkedList<Integer> copiedList = list.copy();
        System.out.print("Копия списка: ");
        System.out.println(copiedList);

        list.reverse();
        System.out.print("Развернутый список: ");
        System.out.println(list);

        boolean isRemoved = list.removeByData(4);
        System.out.println("Элемент 6 удален: " + isRemoved);
    }
}