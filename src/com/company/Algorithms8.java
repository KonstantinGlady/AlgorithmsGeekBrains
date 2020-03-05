package com.company;

import dijkstra.WeightedGraph;

public class Algorithms8 {
    //TODO 1. Изучить алгоритм Дейкстры для поиска кратчайшего пути во взвешенном графе.
    // Реализовать алгоритм восстановления кратчайшего пути из него в вашем методе для поиска в ширину.
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("1");
        weightedGraph.addVertex("2");
        weightedGraph.addVertex("3");
        weightedGraph.addVertex("4");
        weightedGraph.addVertex("5");
        weightedGraph.addVertex("6");
        weightedGraph.addVertex("7");

        weightedGraph.addEdge("1", "2", 7);
        weightedGraph.addEdge("1", "3", 9);
        weightedGraph.addEdge("1", "6", 14);
        weightedGraph.addEdge("2", "3", 10);
        weightedGraph.addEdge("2", "4", 15);
        weightedGraph.addEdge("3", "6", 2);
        weightedGraph.addEdge("3", "4", 11);
        weightedGraph.addEdge("4", "5", 6);
        weightedGraph.addEdge("5", "6", 9);
        weightedGraph.addEdge("6", "7", 5);

        System.out.println(weightedGraph.dijkstra("1", "5"));
    }
   
}
