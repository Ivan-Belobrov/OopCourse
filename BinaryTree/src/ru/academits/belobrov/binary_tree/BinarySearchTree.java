package ru.academits.belobrov.binary_tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E> {
    private Node<E> root;
    private Comparator<E> comparator;
    private int size;

    public BinarySearchTree() {
        size = 0;
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
        size = 0;
    }

    public int countElements() {
        return countElements(root);
    }

    private int countElements(Node<E> node) {
        if (node == null) {
            return 0;
        }

        int leftCount = countElements(node.getLeft());
        int rightCount = countElements(node.getRight());

        return leftCount + rightCount + 1;
    }

    public void insert(E value) {
        root = insertNode(root, value);
    }

    private Node<E> insertNode(Node<E> root, E value) {
        if (root == null) {
            return new Node<>(value);
        }

        if (compare(value, root.getValue()) < 0) {
            root.setLeft(insertNode(root.getLeft(), value));
        } else {
            root.setRight((insertNode(root.getRight(), value)));
        }

        size++;
        return root;
    }

    public boolean contains(E value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node<E> root, E value) {
        Node<E> currentNode = root;

        while (currentNode != null) {
            if (compare(value, currentNode.getValue()) > 0) {
                currentNode = currentNode.getRight();
            } else if (compare(value, currentNode.getValue()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                return true;
            }
        }

        return false;
    }

    public void delete(E value) {
        root = deleteNode(root, value);
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> parentNode = node;
        Node<E> successor = node;
        Node<E> currentNode = node.getRight();

        while (currentNode != null) {
            parentNode = successor;
            successor = currentNode;
            currentNode = currentNode.getLeft();
        }

        if (successor != node.getRight()) {
            parentNode.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }

        return successor;
    }

    private Node<E> deleteNode(Node<E> root, E value) {
        Node<E> currentNode = root;
        Node<E> parentNode = null;
        boolean isLeftChild = true;

        while (currentNode != null && compare(currentNode.getValue(), value) != 0) {
            parentNode = currentNode;

            if (compare(value, currentNode.getValue()) < 0) {
                currentNode = currentNode.getLeft();
                isLeftChild = true;
            } else {
                currentNode = currentNode.getRight();
                isLeftChild = false;
            }
        }

        if (currentNode == null) {
            return root;
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if (currentNode.getRight() == null) {
            if (currentNode == root) {
                root = currentNode.getLeft();
            } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setLeft(currentNode.getLeft());
            }
        } else if (currentNode.getLeft() == null) {
            if (currentNode == root) {
                root = currentNode.getRight();
            } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        } else {
            deleteNodeWithTwoChildren(currentNode, parentNode, isLeftChild);
        }

        size--;
        return root;
    }

    private void deleteNodeWithTwoChildren(Node<E> current, Node<E> parent, boolean isLeftChild) {
        Node<E> successor = getSuccessor(current);

        if (current == root) {
            root = successor;
        } else if (isLeftChild) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }

        successor.setLeft(current.getLeft());
    }

    public void traverseBreadthFirst(Consumer<E> action) {
        if (root == null) {
            return;
        }

        List<E> result = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.poll();
            result.add(currentNode.getValue());

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        System.out.println(result);
    }

    public void traverseDepthFirstRecursive(Consumer<E> action) {
        List<E> result = new ArrayList<>();
        traverseDepthFirstRecursive(root,  result);
        System.out.println(result);
    }

    private void traverseDepthFirstRecursive(Node<E> root,  List<E> result) {

        if (root != null) {
            result.add(root.getValue());
            traverseDepthFirstRecursive(root.getLeft(), result);
            traverseDepthFirstRecursive(root.getRight(), result);
        }
    }

    public void traverseDepthFirst(Consumer<E> action) {
        if (root == null) {
            return;
        }

        List<E> result = new ArrayList<>();
        Deque<Node<E>> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<E> currentNode = stack.pop();
            result.add(currentNode.getValue());

            if (currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }
        }

        System.out.println(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        toString(node.getLeft(), sb);

        if (sb.length() > 0) {
            sb.append(", ");
        }

        sb.append(node.getValue());
        toString(node.getRight(), sb);
    }

    private int compare(E value1, E value2) {
        if (comparator != null) {
            return comparator.compare(value1, value2);
        }

        if (value1 == null || value2 == null) {
            throw new IllegalArgumentException("Значения для сравнения не могут быть null.");
        } else {
            return ((Comparable<E>) value1).compareTo(value2);
        }
    }
}