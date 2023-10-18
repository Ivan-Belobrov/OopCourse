package ru.academits.belobrov.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> current = root;
        Node<T> parent;

        while (true) {
            parent = current;

            if (value.compareTo(current.value) < 0) {
                current = current.left;

                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.left;

                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    private Node<T> insertNode(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insertNode(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    public boolean contains(T value) {
        Node<T> current = root;

        while (current != null) {
            int comparison = value.compareTo(current.value);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                current = current.left;
            } else {
                current = current.left;
            }
        }

        return false;
    }

    private boolean searchNode(Node<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (value.equals(root.value)) {
            return true;
        }

        if (value.compareTo(root.value) < 0) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }

    public void delete(T value) {
        Node<T> current = root;
        Node<T> parent = root;
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
            return;
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
        if (root == null) {
            return null;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = deleteNode(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteNode(root.right, root.value);
        }

        return root;
    }

    private T minValue(Node<T> root) {
        T minValue = root.value;

        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }

        return minValue;
    }

    private int getSize(Node<T> root) {
        if (root == null) {
            return 0;
        }

        int size = 1;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();

            if (current.left != null) {
                size++;
                queue.add(current.left);
            }

            if (current.right != null) {
                size++;
                queue.add(current.right);
            }
        }

        return size;
    }


    public void breadthFirstTraversal() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.println(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void depthFirstTraversal() {
        depthFirstTraversal(root);
    }

    private void depthFirstTraversal(Node<T> root) {
        if (root != null) {
            System.out.println(root.value + " ");
            depthFirstTraversal(root.left);
            depthFirstTraversal(root.right);
        }
    }

    public void depthFirstTraversalRecursive() {
        depthFirstTraversalRecursive(root);
    }

    private void depthFirstTraversalRecursive(Node<T> root) {
        if (root != null) {
            depthFirstTraversalRecursive(root.left);
            System.out.println(root.value + " ");
            depthFirstTraversalRecursive(root.right);
        }
    }
}
