package ru.academits.belobrov.list;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

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

        return getNodeByIndex(index).getData();
    }

    public E setByIndex(int index, E data) {
        checkIndex(index);

        Node<E> node = getNodeByIndex(index);

        E oldData = node.getData();
        node.setData(data);

        return oldData;
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона [0, " + (size - 1) + "], передано: " + index);
        }

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
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона [0, " + (size - 1) + "]: " + index);
        }
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    public boolean removeByData(E data) {
        Node<E> previousNode = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            if (Objects.equals(currentNode.getData(), data)) {
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

        E removedData = head.getData();
        head = head.getNext();
        size--;

        return removedData;
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

        if (head == null) {
            return copyList;
        }

        Node<E> currentNode = head.getNext();
        Node<E> previousCopyNode = new Node<>(head.getData());

        copyList.head = previousCopyNode;
        copyList.size = 1;

        currentNode = currentNode.getNext();

        while (currentNode != null) {
            previousCopyNode.setNext(new Node<>(currentNode.getData()));
            previousCopyNode = previousCopyNode.getNext();
            copyList.size++;
            currentNode = currentNode.getNext();
        }

        return copyList;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node<E> node = head;

        while (node != null) {
            sj.add(node.getData().toString());
            node = node.getNext();
        }

        return sj.toString();
    }
}