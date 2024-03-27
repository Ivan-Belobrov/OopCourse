package ru.academits.belobrov.binary_tree_main;

import ru.academits.belobrov.binary_tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(9);
        tree.insert(10);
        tree.insert(8);
        tree.insert(11);

        System.out.print("Бинарное дереро: " + tree);
        System.out.println();

        System.out.println("Количество элементов в дереве: " + tree.countElements());

        System.out.println("Поиск узла 20: " + tree.contains(20));
        System.out.println("Поиск узла 9: " + tree.contains(9));

        tree.delete(11);
        System.out.println("Удаление узла 11: " + tree);

        System.out.print("Обход в ширину: ");
        tree.traverseBreadthFirst(System.out::print);
        System.out.println();

        System.out.print("Обход в глубину:");
        tree.traverseDepthFirst(System.out::print);
        System.out.println();

        System.out.print("Обход в глубину с рекурсией:");
        tree.traverseDepthFirstRecursive(System.out::print);
        System.out.println();

    }
}