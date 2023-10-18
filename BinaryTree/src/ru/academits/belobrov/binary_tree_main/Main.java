package ru.academits.belobrov.binary_tree_main;

import ru.academits.belobrov.binary_tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(17);
        tree.insert(20);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(26);

        System.out.println("����� ���� 20: " + tree.contains(20));

        tree.delete(20);

        System.out.println("����� ��������� � ������: " + tree.getSize());

        System.out.println("����� � ������:");
        tree.breadthFirstTraversal();
        System.out.println();

        System.out.println("����� � ������� ��� ��������:");
        tree.depthFirstTraversal();
        System.out.println();

        System.out.println("����� � ������� � ���������:");
        tree.depthFirstTraversalRecursive();
        System.out.println();
    }
}