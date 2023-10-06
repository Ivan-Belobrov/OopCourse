package ru.academits.belobrov.list_main;

import ru.academits.belobrov.list.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(2);

        System.out.println("Размер списка:" + list.getSize());

        System.out.println("Первый элемент списка:" + list.getFirst());

        System.out.println("Элемент по индексу 1:" + list.getByIndex(1));

        list.setByIndex(1, 2);
        System.out.println("Измененный элемент по индексу 1:" + list.getByIndex(1));

        int removedElement = list.removeAtIndex(0);
        System.out.println("Удаленный Элемент:" + removedElement);

        System.out.print("Список после удаления элемента:");
        System.out.println(list);

        list.insert(1, 3);
        System.out.print("Список после добавления элемента:");
        System.out.println(list);

        LinkedList<Integer> copiedList = list.copy();
        System.out.print("Копия списка:");
        System.out.println(copiedList);

        list.reverse();
        System.out.print("Развернутый список:");
        System.out.println(list);

        boolean removed = list.removeByValue(3);
        System.out.println("Элемент 6 удален:" + removed);
    }
}