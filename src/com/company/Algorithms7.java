package com.company;

import Graphs.Graph;

public class Algorithms7 {
//TODO 1. Реализовать программу, в которой задается граф из 10 вершин. Задать ребра и найти кратчайший путь с помощью поиска в ширину.
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('J');
        graph.addVertex('K');

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(4, 5); //EF
        graph.addEdge(2, 6); //CG
        graph.addEdge(5, 8); //AJ
        graph.addEdge(3, 9);
        graph.addEdge(4, 7);
        graph.bfs();
    }
}
