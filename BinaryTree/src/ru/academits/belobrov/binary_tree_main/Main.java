package ru.academits.belobrov.binary_tree_main;

import ru.academits.belobrov.binary_tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);

        System.out.print("Бинарное дерево: " + tree);
        System.out.println();

        System.out.println("Количество элементов в дереве: " + tree.getSize());

        System.out.println("Поиск узла 6: " + tree.contains(6));

        System.out.println("Удаление узла 10: " + tree.delete(10));
        System.out.println("Поиск узла 10: " + tree.contains(10));

        System.out.print("Обход в ширину: ");
        tree.traverseBreadthFirst(System.out::print);
        System.out.println();

        System.out.print("Обход в глубину: ");
        tree.traverseDepthFirst(System.out::print);
        System.out.println();

        System.out.print("Обход в глубину с рекурсией: ");
        tree.traverseDepthFirstRecursive(System.out::print);
    }
}