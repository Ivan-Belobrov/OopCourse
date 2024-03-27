package ru.academits.belobrov.binary_tree;

class Node<E> {
    private final E value;
    private Node<E> left;
    private Node<E> right;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}