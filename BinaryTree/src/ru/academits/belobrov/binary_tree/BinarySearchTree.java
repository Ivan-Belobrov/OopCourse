package ru.academits.belobrov.binary_tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E> {
    private final Comparator<E> comparator;
    private Node<E> root;
    private int size;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        comparator = null;
    }

    public int getSize() {
        return size;
    }

    public void insert(E value) {
        Node<E> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node<E> node = root;

        while (true) {
            if (compare(value, node.getValue()) < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(newNode);
                    size++;
                    return;
                }

                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(newNode);
                    size++;
                    return;
                }

                node = node.getRight();
            }
        }
    }

    public boolean contains(E value) {
        Node<E> node = root;

        while (node != null) {
            int comparisonResult = compare(value, node.getValue());

            if (comparisonResult > 0) {
                node = node.getRight();
            } else if (comparisonResult < 0) {
                node = node.getLeft();
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean delete(E value) {
        if (root == null) {
            return false;
        }

        Node<E> currentNode = root;
        Node<E> parentNode = null;
        boolean isLeftChild = true;

        while (true) {
            int comparisonResult = compare(value, currentNode.getValue());

            if (comparisonResult == 0) {
                break;
            }

            parentNode = currentNode;

            if (comparisonResult < 0) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }

            if (currentNode == null) {
                return false;
            }
        }

        Node<E> successor;

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            successor = null;
        } else if (currentNode.getRight() == null) {
            successor = currentNode.getLeft();
        } else if (currentNode.getLeft() == null) {
            successor = currentNode.getRight();
        } else {
            successor = getSuccessor(currentNode);
        }

        if (currentNode == root) {
            root = successor;
        } else if (isLeftChild) {
            parentNode.setLeft(successor);
        } else {
            parentNode.setRight(successor);
        }

        --size;
        return true;
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> successorParent = node;
        Node<E> successor = node.getRight();

        while (successor.getLeft() != null) {
            successorParent = successor;
            successor = successor.getLeft();
        }

        if (successor != node.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }

        successor.setLeft(node.getLeft());

        return successor;
    }

    public void traverseBreadthFirst(Consumer<E> consumer) {
        if (root == null) {
            return;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.poll();
            consumer.accept(currentNode.getValue());

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
    }

    public void traverseDepthFirstRecursive(Consumer<E> consumer) {
        traverseDepthFirstRecursive(root, consumer);
    }

    private void traverseDepthFirstRecursive(Node<E> root, Consumer<E> consumer) {
        if (root != null) {
            consumer.accept(root.getValue());

            traverseDepthFirstRecursive(root.getLeft(), consumer);
            traverseDepthFirstRecursive(root.getRight(), consumer);
        }
    }

    public void traverseDepthFirst(Consumer<E> consumer) {
        if (root == null) {
            return;
        }

        Deque<Node<E>> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<E> currentNode = stack.pop();
            consumer.accept(currentNode.getValue());

            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }

            if (currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        traverseBreadthFirst(value -> sb.append(value).append(", "));

        sb.setLength(sb.length() - 2);

        sb.append(']');
        return sb.toString();
    }

    private int compare(E value1, E value2) {
        if (comparator != null) {
            return comparator.compare(value1, value2);
        }

        if (value1 == null && value2 == null) {
            return 0;
        }

        if (value1 == null) {
            return -1;
        }

        if (value2 == null) {
            return 1;
        }

        //noinspection unchecked
        return ((Comparable<E>) value1).compareTo(value2);
    }
}