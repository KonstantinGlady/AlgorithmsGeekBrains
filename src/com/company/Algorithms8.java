package com.company;

import LinkedHash.HashMap;
import LinkedHash.LinkedHashEntry;
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


        //TODO 2. Создать класс - хэш-тблицу, реализующую метод цепочек (хранение элементов в виде односвязного списка
        // в случае коллизии). За основу взять код из методички. Размер массива хеш-таблицы задавать при ее создании.
        // Увеличение размера массива реализовывать не обязательно. Для приведения значения хэша добавляемых объектов
        // к диапазону индексов массива использовать двойное хэширования.
        // У класса хэш таблицы должны быть методы void add(T item); void remove(T item); boolean contains(T item);
        System.out.println("hash");
        int size = 10;
        int n = 8;
        int l = 10;
        LinkedHashEntry entry;

        HashMap map = new HashMap(size);
       /* for (int i = 0; i < n; i++) {
            int key = (int) (Math.random() * size * l);
            map.add(key, key);
        }*/
        map.display();
        map.add(10, 10);
        map.add(11, 11);
        map.add(12, 12);
        map.add(22, 22);
        map.add(20, 20);
        map.add(22, 22);


        System.out.println("added 10");
        map.display();
        if (map.contains(10)) {
            map.remove(10);
            System.out.println("removed 10");
        }

        map.display();
    }


}
