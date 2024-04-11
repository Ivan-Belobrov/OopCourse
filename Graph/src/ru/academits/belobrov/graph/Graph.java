package ru.academits.belobrov.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class Graph {
    private final int[][] matrix;

    public Graph(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матрица не может быть бустой.");
        }

        int rows = matrix.length;

        for (int[] row : matrix) {
            if (row == null || row.length != rows) {
                throw new IllegalArgumentException("Матрица должна быть квадратной.");
            }
        }

        this.matrix = matrix;
    }

    public List<List<Integer>> breadthFirstTraversal(int startVertex) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];
        List<List<Integer>> components = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Integer> component = new ArrayList<>();

            component.add(vertex);

            for (int i = 0; i < verticesCount; i++) {
                if (matrix[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }

            components.add(component);
        }

        return components;
    }

    public List<List<Integer>> depthFirstTraversalRecursive(int startVertex) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];
        List<List<Integer>> components = new ArrayList<>();

        List<Integer> component = new ArrayList<>();
        depthFirstTraversalRecursive(startVertex, visited, component);
        components.add(component);

        return components;
    }

    private void depthFirstTraversalRecursive(int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                depthFirstTraversalRecursive(i, visited, component);
            }
        }
    }

    public List<List<Integer>> depthFirstTraversal(int startVertex) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];
        List<List<Integer>> components = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> component = new ArrayList<>();

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (!visited[vertex]) {
                visited[vertex] = true;
                component.add(vertex);

                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[vertex][i] == 1 && !visited[i]) {
                        queue.add(i);
                    }
                }
            }
        }

        components.add(component);

        return components;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < matrix.length; i++) {
            sb.append(i);

            if (i < matrix.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}