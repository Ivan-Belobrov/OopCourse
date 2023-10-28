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
        Node<E> node = getNodeByIndex(index);

        return node.getData();
    }

    public E setByIndex(int index, E newData) {
        checkIndex(index);

        Node<E> node = getNodeByIndex(index);

        E oldData = node.getData();
        node.setData(newData);

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
        checkIndex(index);

        if (index == size) {
            Node<E> node = new Node<>(data, null);

            if (head == null) {
                head = node;
            } else {
                Node<E> lastNode = getNodeByIndex(size - 1);
                lastNode.setNext(node);
            }

            size++;
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
            throw new IndexOutOfBoundsException("Индекс: " + index + ", находится вне диапазона допустимых значений [0, " + (size - 1) + "]");
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

        Node<E> currentNode = head;
        Node<E> previousNode = null;

        copyList.head = new Node<>(currentNode.getData());

        previousNode = copyList.head;
        copyList.size++;

        currentNode = currentNode.getNext();

        while (currentNode != null) {
            previousNode.setNext(new Node<>(currentNode.getData()));
            previousNode = previousNode.getNext();
            copyList.size++;
            currentNode = currentNode.getNext();
        }

        return copyList;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<E> node = head;

        while (node != null) {
            sb.append(node.getData());

            if (node.getNext() != null) {
                sb.append(", ");
            }

            node = node.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}