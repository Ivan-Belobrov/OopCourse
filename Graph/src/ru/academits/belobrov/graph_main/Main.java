package ru.academits.belobrov.graph_main;

import ru.academits.belobrov.graph.GraphTraversal;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0}
        };

        GraphTraversal traversal = new GraphTraversal(graph);
        traversal.traversalBreadthFirstSearch();
        System.out.println("Поиск в ширину");
        System.out.println(traversal);

        traversal = new GraphTraversal(graph);
        traversal.traversalDepthFirstSearch();
        System.out.println("Поиск в глубину");
        System.out.println(traversal);
    }
}