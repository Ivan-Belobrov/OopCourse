package ru.academits.belobrov.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.function.IntConsumer;

public class Graph {
    private final int[][] matrix;

    public Graph(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матрица не может быть null.");
        }

        int rowsCount = matrix.length;

        for (int[] row : matrix) {
            if (row == null || row.length != rowsCount) {
                throw new IllegalArgumentException("Матрица должна быть квадратной.");
            }
        }

        this.matrix = matrix;
    }

    public void traverseBreadthFirst(IntConsumer action) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int currentVertex = queue.poll();
                    action.accept(currentVertex);

                    for (int j = 0; j < verticesCount; j++) {
                        if (matrix[currentVertex][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }

    public void traverseDepthFirstRecursive(IntConsumer action) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            if (!visited[i]) {
                traverseDepthFirstRecursive(i, visited, action);
            }
        }
    }

    private void traverseDepthFirstRecursive(int vertex, boolean[] visited, IntConsumer action) {
        visited[vertex] = true;
        action.accept(vertex);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                traverseDepthFirstRecursive(i, visited, action);
            }
        }
    }

    public List<Integer> traverseDepthFirst(int startVertex) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];

        List<Integer> component = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

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

        return component;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < matrix.length; i++) {
            sb.append(i);
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]");

        return sb.toString();
    }
}