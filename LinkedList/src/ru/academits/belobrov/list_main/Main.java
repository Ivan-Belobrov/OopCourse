package ru.academits.belobrov.list_main;

import ru.academits.belobrov.list.Node;

public class Main {

    public static void main(String[] args) {
        Node.LinkedList<Integer> list = new Node.LinkedList<>();

        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(1);
        System.out.println("Размер списка: " + list.getSize());

        System.out.println("Первый элемент списка: " + list.getFirst());

        System.out.println("Элемент по индексу 1: " + list.getIndex(1));

        list.setIndex(1, 4);
        System.out.println("Измененный элемент по индексу 1: " + list.getIndex(1));

        int removedElement = list.remove(0);
        System.out.println("Удаленный Элемент: " + removedElement);

        System.out.println("Список после удаления элемента: ");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getIndex(i));
        }

        list.insert(1, 6);
        System.out.println("Список после добавления элемента: ");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getIndex(i));
        }

        boolean removed = list.removeByValue(6);
        System.out.println("Элемент 6 удален: " + removed);

        list.reverse();
        System.out.println("Развернутый список: ");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getIndex(i));
        }

        Node.LinkedList<Integer> copyList = list.copy();
        System.out.println("Копия списка: ");
        for (int i = 0; i < copyList.getSize(); i++) {
            System.out.println(copyList.getIndex(i));
        }
    }
}
