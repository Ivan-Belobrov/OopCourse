package ru.academits.belobrov.binary_tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E> {
    private Node<E> root;
    private final Comparator<E> comparator;
    private int size;

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
                    break;
                } else {
                    node = node.getLeft();
                }
            } else {
                if (node.getRight() == null) {
                    node.setRight(newNode);
                    size++;
                    break;
                } else {
                    node = node.getRight();
                }
            }
        }
    }

    public boolean contains(E value) {
        Node<E> node = root;

        while (node != null) {
            int result = compare(value, node.getValue());

            if (result > 0) {
                node = node.getRight();
            } else if (result < 0) {
                node = node.getLeft();
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean delete(E value) {
        Node<E> currentNode = root;
        Node<E> parentNode = null;
        boolean isLeftChild = true;

        while (currentNode.getValue() != value) {
            int comparisonResult = compare(value, currentNode.getValue());

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

        if (parentNode != null) {
            Node<E> successor = getSuccessor(currentNode);

            if (currentNode == root) {
                root = successor;
            } else if (isLeftChild) {
                parentNode.setLeft(successor);
            } else {
                parentNode.setRight(successor);
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
                    parentNode.setRight(currentNode.getLeft());
                }
            } else if (currentNode.getLeft() == null) {
                if (currentNode == root) {
                    root = currentNode.getRight();
                } else if (isLeftChild) {
                    parentNode.setLeft(currentNode.getRight());
                } else {
                    parentNode.setRight(currentNode.getRight());
                }
            }
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
        sb.append("[");

        traverseBreadthFirst(value -> sb.append(value).append(", "));

        sb.setLength(sb.length() - 2);

        sb.append("]");
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