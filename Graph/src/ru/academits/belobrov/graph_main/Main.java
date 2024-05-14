package ru.academits.belobrov.graph_main;

import ru.academits.belobrov.graph.Graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

        Graph graph = new Graph(matrix);
        System.out.print("Обход в ширину: ");
        graph.traverseBreadthFirst(vertex -> System.out.print(vertex + " "));
        System.out.println();

        System.out.print("Обход в глубину с рекурсией: ");
        graph.traverseDepthFirstRecursive(vertex -> System.out.print(vertex + " "));
        System.out.println();

        System.out.print("Обход в глубину: ");
        List<Integer> component = graph.traverseDepthFirst(0);
        for (int vertex : component) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}