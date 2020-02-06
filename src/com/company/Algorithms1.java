package com.company;

import support.Support;

import java.util.Arrays;

public class Algorithms1 {
    static int[] arrIn = Support.getIntArray();

    public static void main(String[] args) {

        //TODO 1. Есть массив целых чисел. Найти все тройки чисел, которые в сумме дают ноль
        System.out.println("Задание. Тройки в сумме ноль:");
        System.out.println(Arrays.toString(arrIn));
        for (int i = 0; i < arrIn.length; i++) {
            for (int j = i + 1; j < arrIn.length; j++) {
                getZero(i, j);

            }
        }


        //TODO 2.Есть массив целых чисел. Найти два наибольших значения в массиве
        System.out.println("Задание. Наибольшие значения: ");
        int[] arrIn = Support.getRandomIntArray(100, -100, 100);
        System.out.println(Arrays.toString(arrIn));
        int biggestOne = arrIn[0];
        int biggestSecond = arrIn[1];
        for (int a : arrIn) {
            if (a > biggestOne) {
                biggestSecond = biggestOne;
                biggestOne = a;
              
            }

        }
        System.out.println("Наибольшее значение: " + biggestOne);
        System.out.println("Второе наибольшее значение: " + biggestSecond);
    }

    private static void getZero(int i, int j) {

        for (int k = 0; k < arrIn.length; k++) {
            if (k != i && k != j) {
                if ((arrIn[k] + arrIn[i] + arrIn[j]) == 0) {

                    System.out.println(arrIn[i] + "  " + arrIn[j] + "  " + arrIn[k]);
                    //break; // можно убрать часть дублей идущих подряд,если нужны только значения, а не позиции в массиве для ускорения обхода
                }
            }

        }
    }
}
