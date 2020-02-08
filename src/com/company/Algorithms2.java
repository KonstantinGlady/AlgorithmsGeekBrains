package com.company;

import java.util.Arrays;

import support.IntArray;
import support.Support;


public class Algorithms2 {
    public static void main(String[] args) {
        //TODO 1. Создать массив большого размера (миллион элементов).
        IntArray arr = new IntArray(1_000_000);
        //System.out.println(arr.toString());

        //TODO 2. Написать методы удаления, добавления, поиска элемента массива.
        IntArray arr2 = new IntArray(50);
        System.out.println("insert");
        arr2.insert(2);
        arr2.insert(5);
        arr2.insert(2);
        arr2.insert(2);
        arr2.display();

        System.out.println("find value: " + arr2.getElement(1));
        System.out.println("find index: " + arr2.getIndex(5));

        System.out.println("delete");
        //arr2.binaryFind(5); требуется предварительная сортировка в массиве по возрастанию
        if (arr2.find(5)) {
            arr2.delete(5);//элемент есть
        }
        arr2.display();
        arr2.delete(5);// элемента нет, выведем сообщение

        //TODO 3. Заполнить массив случайными числами.
        int[] arr3 = Support.getRandomIntArray(10, 0, 333);
        System.out.println("random: " + Arrays.toString(arr3));

        IntArray arr4 = new IntArray(100, 0, 100);
        System.out.println("random: " + arr4.toString());

        //TODO 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
        IntArray arr5 = new IntArray();
        System.out.println("before sorting: " + arr5.toString());
        long time =System.nanoTime();
        arr5.sortBubble();
        System.out.println("timer:"+ (System.nanoTime()-time));
        System.out.println("bubble sorting: " + arr5.toString());

        IntArray arr6 = new IntArray();
        System.out.println("before sorting: " + arr6.toString());
         time =System.nanoTime();
        arr6.sortSelect();
        System.out.println("timer:"+ (System.nanoTime()-time));
        System.out.println("select sorting: " + arr6.toString());

        IntArray arr7 = new IntArray();
        System.out.println("before sorting: " + arr7.toString());
         time =System.nanoTime();
        arr7.sortInsert();
        System.out.println("timer:"+ (System.nanoTime()-time));
        System.out.println("insert sorting: " + arr7.toString());

        //int[] array = {4,1,5,2};
        int[] array = {2, 3, 8, 1, 5, 11, 21, 34, 65, 78};
         time =System.nanoTime();
        Support.mergeSort(array);
        System.out.println("timer:"+ (System.nanoTime()-time));
        System.out.println("merge sorting: "+Arrays.toString(array));
    }

}
