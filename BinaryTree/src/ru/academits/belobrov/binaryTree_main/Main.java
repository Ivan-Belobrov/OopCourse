package ru.academits.belobrov.binaryTree_main;

import ru.academits.belobrov.binaryTree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(60);
        tree.insert(40);
        tree.insert(20);
        tree.insert(80);
        tree.insert(90);

        System.out.println("����� ���� 40: " + tree.search(40));

        tree.delete(40);

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