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

        Graph graph = new Graph(matrix);
        System.out.print("Обход в ширину: ");
        graph.traverseBreadthFirst(System.out::print);
        System.out.println();

        graph = new Graph(matrix);
        System.out.println("Обход в глубину: " + graph.traverseDepthFirst(0));

        graph = new Graph(matrix);
        System.out.println("Обход в глубину с рекурсией: " + graph.traverseDepthFirstRecursive(0));
    }
}