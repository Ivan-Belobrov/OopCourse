package ru.academits.belobrov.graph_main;

import ru.academits.belobrov.graph.Graph;

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

        Graph traversal = new Graph(matrix);
        traversal.breadthFirstTraversal(0);
        System.out.print("Обход в ширину: ");
        System.out.println(traversal);

        traversal = new Graph(matrix);
        traversal.depthFirstTraversal(0);
        System.out.print("Обход в глубину: ");
        System.out.println(traversal);

        traversal = new Graph(matrix);
        traversal.depthFirstTraversalRecursive(0);
        System.out.print("Обход в глубину с рекурсией: ");
        System.out.println(traversal);
    }
}