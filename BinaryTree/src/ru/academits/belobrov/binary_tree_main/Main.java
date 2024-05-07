package ru.academits.belobrov.binary_tree_main;

import ru.academits.belobrov.binary_tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(8);
        tree.insert(10);
        tree.insert(3);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);
        tree.insert(1);
        tree.insert(6);

        System.out.print("Бинарное дерево: " + tree);
        System.out.println();

        System.out.println("Количество элементов в дереве: " + tree.getSize());

        int node = 6;
        System.out.println("Поиск узла " + node + ": " + tree.contains(node));
        System.out.println("Удаление узла " + node + ": " + tree.delete(node));
        System.out.println("Поиск узла " + node + ": " + tree.contains(node));

        System.out.print("Обход в ширину: ");
        tree.traverseBreadthFirst(e -> System.out.print(e + " "));
        System.out.println();

        System.out.print("Обход в глубину: ");
        tree.traverseDepthFirst(e -> System.out.print(e + " "));
        System.out.println();

        System.out.print("Обход в глубину с рекурсией: ");
        tree.traverseDepthFirstRecursive(e -> System.out.print(e + " "));
    }
}