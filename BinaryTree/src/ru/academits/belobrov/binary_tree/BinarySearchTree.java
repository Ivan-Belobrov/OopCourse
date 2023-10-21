package ru.academits.belobrov.binary_tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private Comparator<T> comparator;
    private int size;

    public BinarySearchTree() {
        size = 1;
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        size = 1;
    }

    public void insert(T value) {
        root = insertNode(root, value);
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> insertNode(Node<T> root, T value) {
        Node<T> newNode = new Node<>(value);

        if (root == null) {
            return newNode;
        }

        Node<T> current = root;
        Node<T> parent = null;

        while (current != null) {
            parent = current;

            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        size++;
        return root;
    }

    public boolean contains(T value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node<T> root, T value) {
        Node<T> current = root;

        while (current != null) {
            if (value.equals(current.value)) {
                return true;
            } else if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public void delete(T value) {
        root = deleteNode(root, value);
    }

    private Node<T> getSuccessor(Node<T> node) {
        Node<T> parent = node;
        Node<T> successor = node;
        Node<T> current = node.right;

        while (current != null) {
            parent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right) {
            parent.left = successor.right;
            successor.right = node.right;
        }

        return successor;
    }

    private Node<T> deleteNode(Node<T> root, T value) {
        Node<T> current = root;
        Node<T> parent = null;
        boolean isLeftChild = true;

        while (current != null && current.value.compareTo(value) != 0) {
            parent = current;

            if (value.compareTo(current.value) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            return root;
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            deleteNodeWithTwoChildren(current, parent, isLeftChild);
        }

        size--;
        return root;
    }

    private void deleteNodeWithTwoChildren(Node<T> current, Node<T> parent, boolean isLeftChild) {
        Node<T> successor = getSuccessor(current);

        if (current == root) {
            root = successor;
        } else if (isLeftChild) {
            parent.left = successor;
        } else {
            parent.right = successor;
        }

        successor.left = current.left;
    }

    private T findMinValue(Node<T> root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.value;
    }

    public int getSize() {
        return size;
    }


    public void traversalBreadthFirst(Consumer<T> action) {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            action.accept(current.value);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void traversalDepthFirstRecursive(Consumer<T> action) {
        traversalDepthFirstRecursive(root, action);
    }

    private void traversalDepthFirstRecursive(Node<T> root, Consumer<T> action) {
        if (root != null) {
            traversalDepthFirstRecursive(root.left, action);
            action.accept(root.value);
            traversalDepthFirstRecursive(root.right, action);
        }
    }

    public void traversalDepthFirstIterative(Consumer<T> action) {
        if (root == null) {
            return;
        }

        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            action.accept(current.value);

            current = current.right;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);

        return sb.toString();
    }

    private void toString(Node<T> root, StringBuilder sb) {
        if (root != null) {
            toString(root.left, sb);
            sb.append(root.value).append(' ');
            toString(root.right, sb);
        }
    }

    private int compare(T value1, T value2) {
        if (comparator != null) {
            return comparator.compare(value1, value2);
        } else if (value1 != null && value2 != null) {
            return (value1.compareTo(value2));
        } else {
            throw new IllegalArgumentException("Нет валидного компаратора или сопоставимой реализации.");
        }
    }
}