package ru.academits.belobrov.list;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static class LinkedList<T> {
        private Node<T> head;
        private int size;

        public LinkedList() {
            this.head = null;
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public T getFirst() {
            if (head != null) {
                return head.getData();
            }

            return null;
        }

        public T getIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                if (current == null || current.getNext() == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.getNext();
            }

            if (current == null) {
                throw new IndexOutOfBoundsException();
            }

            return current.getData();
        }

        public T setIndex(int index, T data) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            T oldValue = current.getData();
            current.setData(data);
            return oldValue;
        }

        public T remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            if (index == 0) {
                return removeFirst();
            }

            Node<T> previous = null;
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }

            previous.setNext(current.getNext());
            size--;

            return current.getData();
        }

        public void insertFirst(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(head);
            head = newNode;
            size++;
        }

        public void insert(int index, T data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            if (index == 0) {
                insertFirst(data);
            }

            Node<T> newNode = new Node<>(data);
            Node<T> previous = null;
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }

            if (previous != null) {
                previous.setNext(newNode);
            }

            newNode.setNext(current);
            size++;
        }

        public boolean removeByValue(T data) {
            Node<T> previous = null;
            Node<T> current = head;
            while (current != null) {
                if (current.getData().equals(data)) {
                    if (previous == null) {
                        head = current.getNext();
                    } else {
                        previous.setNext(current.getNext());
                    }

                    size++;
                    return true;
                }

                previous = current;
                current = current.getNext();
            }

            return false;
        }

        public T removeFirst() {
            if (head == null) {
                return null;
            }

            T data = head.getData();
            head = head.getNext();
            size--;

            return data;
        }

        public void reverse() {
            Node<T> previous = null;
            Node<T> current = head;
            Node<T> next = null;

            while (current != null) {
                next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            }

            head = previous;
        }

        public LinkedList<T> copy() {
            LinkedList<T> newList = new LinkedList<>();
            Node<T> current = head;

            while (current != null) {
                newList.insertFirst(current.getData());
                current = current.getNext();
            }

            return newList;
        }
    }
}