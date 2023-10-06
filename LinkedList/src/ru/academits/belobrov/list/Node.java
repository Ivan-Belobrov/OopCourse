package ru.academits.belobrov.list;

class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> head) {
        this.data = data;
        this.next = head;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}