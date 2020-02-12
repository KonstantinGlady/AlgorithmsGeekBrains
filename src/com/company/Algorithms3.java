package com.company;

import support.*;

import java.io.*;


public class Algorithms3 {
    public static void main(String[] args) throws IOException {
        //TODO 1. Реализовать рассмотренные структуры данных в консольных программах.
        //stack throw class Bracket
        String input;
        while (true) {
            input = getString();
            if (input.equals("")) {
                break;
            }
            Bracket bracket = new Bracket(input);
            bracket.check();
        }
        //queue
        Queue<Integer> queue = new Queue<>(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.remove();
        queue.remove();
        queue.insert(60);
        queue.insert(70);

        while (!queue.isEmpty()) {
            System.out.printf("queue: %d%n", queue.remove());
        }

        //priorityQueue
        PriorityQueue prioQueue = new PriorityQueue(5);
        prioQueue.insert(10);
        prioQueue.insert(40);
        prioQueue.insert(50);
        prioQueue.insert(30);
        prioQueue.insert(20);
        while (!prioQueue.isEmpty()) {
            System.out.printf("prioqueue: %d%n", prioQueue.remove());
        }

        //TODO 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
        String string;
        while (true) {
            string = getString();
            System.out.println("string from console: "+ string);
            if (string.equals("")) {
                break;
            }
            reverseString(string);// 1 way
            System.out.println("");
            System.out.println(reverse(string)); // another one
        }

        //TODO 3. Создать класс для реализации дека.

        ArrayDeque<Integer> deque = new ArrayDeque<>(10);
        deque.addFirst(11);
        deque.addFirst(22);
        deque.addFirst(33);
        System.out.println("deleted: " + deque.removeFirst());
        deque.addFirst(44);
        deque.addLast(10);
        deque.addLast(20);
        System.out.println("deleted: " + deque.removeLast());
        for (int i = 0; i < 10; i++) {
            System.out.println(deque.removeFirst());
        }

    }

    private static String reverse(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return reverse(b) + reverse(a);
    }

    private static void reverseString(String string) {
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
    }

    private static String getString() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
