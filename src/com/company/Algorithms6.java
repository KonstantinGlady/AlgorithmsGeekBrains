package com.company;

import Trees.Tree;

import java.util.Random;

public class Algorithms6 {
    //TODO 1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать
    // деревьев с глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев, представляются
    // в виде чисел типа int. Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
    // TODO 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
    public static void main(String[] args) {
        int numberOftrees = 20;
        int numberBalancedTrees = 0;
        for (int i = 0; i < numberOftrees; i++) {
            Tree tree = new Tree();
            while (!tree.getMaxSizeLimit()) {
                tree.insert(getRndInt(-100, 100));
            }
            tree.display();
            tree.displayTreeHeight();
            if (tree.isBalanced()) {
                numberBalancedTrees +=1;
            }
            System.out.println("Tree is balanced: " + tree.isBalanced());
        }
        int unbalanced = 100 - (numberBalancedTrees*100/numberOftrees);
        System.out.println("Percent of unbalanced trees: "+ unbalanced);
    }

    private static int getRndInt(int min, int max) {
        Random rnd = new Random();
        int r = rnd.nextInt(max - min) + min;
        System.out.print(r +" ");
        return r;   // return (new Random().nextInt(max - min)+min);
    }

}
