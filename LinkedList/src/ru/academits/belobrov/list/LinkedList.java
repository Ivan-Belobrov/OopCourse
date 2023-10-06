package ru.academits.belobrov.list;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private Node<E> head;
    private int size;

    public int getSize() {
        return size;
    }

    public E getFirst() {
        if (head != null) {
            return head.getData();
        }

        throw new NoSuchElementException("Список пустой.");
    }

    public E getByIndex(int index) {
        checkIndex(index);

        Node<E> nodeAtIndex = getNodeByIndex(index);

        if (nodeAtIndex != null) {
            return nodeAtIndex.getData();
        } else {
            throw new NullPointerException("Элемент с заданным индексом равен null.");
        }
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
            return deletedData();
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
        } else {
            Node<E> previousNode = getNodeByIndex(index - 1);
            Node<E> node = previousNode.getNext();
            previousNode.setNext(new Node<>(data, node));
            size++;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index + ", допустимый индекс [0, " + (size - 1) + "]");
        }
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);

        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            if (node == null) {
                throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
            }

            node = node.getNext();
        }

        return node;
    }

    public boolean removeByValue(E value) {
        Node<E> previousNode = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData() == null && value == null) {
                if (previousNode == null) {
                    head = head.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }

                size++;

                return true;
            } else if (currentNode.getData() == null && currentNode.getData().equals(value)) {
                if (previousNode == null) {
                    head = head.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }

                size++;

                return true;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return false;
    }

    public E deletedData() {
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
        Node<E> node = head;

        while (node != null) {
            Node<E> next = node.getNext();
            node.setNext(previousNode);
            previousNode = node;
            node = next;
        }

        head = previousNode;
    }

    public LinkedList<E> copy() {
        LinkedList<E> newList = new LinkedList<>();
        Node<E> node = head;
        Node<E> tail = null;

        while (node != null) {
            Node<E> newNode = new Node<>(node.getData(), null);

            if (tail == null) {
                newList.head = newNode;
            } else {
                tail.setNext(newNode);
            }

            tail = newNode;
            newList.size++;
            node = node.getNext();
        }

        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;

        while (node != null) {
            sb.append(node.getData()).append(" ");
            node = node.getNext();
        }

        return sb.toString();
    }
}