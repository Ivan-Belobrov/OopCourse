package ru.academits.belobrov.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<E> {
    private Node<E> head;
    private int size;

    public int getSize() {
        return size;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пустой.");
        }

        return head.getData();
    }

    public E getByIndex(int index) {
        checkIndex(index);
        Node<E> nodeAtIndex = getNodeByIndex(index);

        return nodeAtIndex.getData();
    }

    public E setByIndex(int index, E newValue) {
        checkIndex(index);

        Node<E> nodeAtIndex = getNodeByIndex(index);

        E oldValue = nodeAtIndex.getData();
        nodeAtIndex.setData(newValue);

        return oldValue;
    }

    public E removeAtIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        Node<E> previousNode = getNodeByIndex(index);
        Node<E> nodeToRemove = previousNode.getNext();

        previousNode.setNext(nodeToRemove.getNext());
        size--;

        return nodeToRemove.getData();
    }

    public void insertFirst(E data) {
        head = new Node<>(data, head);
        size++;
    }

    public void insert(int index, E data) {
        checkIndex(index);

        if (index == 0) {
            insertFirst(data);
            return;
        }

        Node<E> previousNode = getNodeByIndex(index - 1);
        Node<E> currentNode = previousNode.getNext();
        previousNode.setNext(new Node<>(data, currentNode));
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index + ", допустимый индекс [0, " + size + "]");
        }
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);

        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    public boolean removeByValue(E value) {
        Node<E> previousNode = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            if (Objects.equals(currentNode.getData(), value)) {
                if (previousNode == null) {
                    head = head.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }

                size--;
                return true;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return false;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пустой.");
        }

        E data = head.getData();
        head = head.getNext();
        size--;

        return data;
    }

    public void reverse() {
        Node<E> previousNode = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            Node<E> nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;
    }

    public LinkedList<E> copy() {
        LinkedList<E> copyList = new LinkedList<>();
        Node<E> currentNode = head;
        Node<E> previousNode = null;

        if (currentNode != null) {
            Node<E> newNode = new Node<>(currentNode.getData(), null);
            copyList.head = newNode;
            previousNode = newNode;
            copyList.size++;
            currentNode = currentNode.getNext();
        }

        while (currentNode != null) {
            Node<E> newNode = new Node<>(currentNode.getData(), null);
            previousNode.setNext(newNode);
            previousNode = newNode;
            copyList.size++;
            currentNode = currentNode.getNext();
        }

        return copyList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<E> node = head;

        while (node != null) {
            sb.append(node.getData()).append(" ");
            node = node.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}