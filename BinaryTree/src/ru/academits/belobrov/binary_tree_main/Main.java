package ru.academits.belobrov.binary_tree_main;

import ru.academits.belobrov.binary_tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(17);
        tree.insert(20);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);

        System.out.println("КОличество элементов в дереве: " + tree.getSize());

        System.out.println("Поиск узла 20: " + tree.contains(20));

        tree.delete(20);

        System.out.println("Обход в ширину:");
        tree.traversalBreadthFirst(System.out::println);
        System.out.println();

        System.out.println("Обход в глубину без рекурсии:");
        tree.traversalDepthFirstIterative(System.out::println);
        System.out.println();

        System.out.println("Обход в глубину с рекурсией:");
        tree.traversalDepthFirstRecursive(System.out::println);
        System.out.println();
    }
}