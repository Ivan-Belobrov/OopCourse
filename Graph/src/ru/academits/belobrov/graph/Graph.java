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
            throw new IllegalArgumentException("Матрица не может быть пустой.");
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

    public void traverseDepthFirstRecursive(IntConsumer consumer) {
        int verticesCount = matrix.length;
        boolean[] visited = new boolean[verticesCount];
        List<List<Integer>> components = new ArrayList<>();

        List<Integer> component = new ArrayList<>();
        traverseDepthFirstRecursive(consumer, visited, component);
        components.add(component);

        return components;
    }

    private void traverseDepthFirstRecursive(IntConsumer consumer, boolean[] visited, List<Integer> component) {
        visited[consumer] = true;
        component.add(consumer);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[consumer][i] == 1 && !visited[i]) {
                traverseDepthFirstRecursive(i, visited, component);
            }
        }
    }

    public List<List<Integer>> traverseDepthFirst(int startVertex) {
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