package ru.academits.belobrov.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class GraphTraversal {
    private final int[][] graph;
    private final boolean[] visited;
    private final List<List<Integer>> components;

    public GraphTraversal(int[][] graph) {
        this.graph = graph;
        int numVertices = graph.length;
        visited = new boolean[numVertices];
        components = new ArrayList<>();
    }

    public void traversalBreadthFirstSearch() {
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int vertex = queue.poll();
                    component.add(vertex);

                    for (int j = 0; j < graph.length; j++) {
                        if (graph[vertex][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }

                components.add(component);
            }
        }
    }

    public void traversalDepthFirstSearch() {
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                depthFirstSearch(i, component);
                components.add(component);
            }
        }
    }

    private void depthFirstSearch(int vertex, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                depthFirstSearch(i, component);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (List<Integer> component : components) {
            sb.append(component).append("\n");
        }

        return sb.toString();
    }
}