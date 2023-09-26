package ru.academits.belobrov.binaryTree;

import ru.academits.belobrov.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    //вставка узда в дерево
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else if (value > root.value) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    //поиск узла в дереве
    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        if (value < root.value) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }

    //удаление первого узла по вхождению
    public void delete(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteNode(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;

        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }

        return minValue;
    }

    //Получение числа элементов в дереве
    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.left) + getSize(root.right);
        }
    }

    //Обходы в ширину и глубину
    public void breadthFirstTraversal(){
        if (root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.value + " ");

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }
    }

    public void depthFirstTraversal(){
        depthFirstTraversal(root);
    }

    private void depthFirstTraversal(Node root){
        if (root != null){
            System.out.println(root.value + " ");
            depthFirstTraversal(root.left);
            depthFirstTraversal(root.right);
        }
    }

    public void depthFirstTraversalRecursive(){
        depthFirstTraversalRecursive(root);
    }

    private void depthFirstTraversalRecursive(Node root){
        if (root != null){
            depthFirstTraversalRecursive(root.left);
            System.out.println(root.value + " ");
            depthFirstTraversalRecursive(root.right);
        }
    }
}