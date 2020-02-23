package com.company;


import Recursions.Backpack;
import Recursions.RecursiveDescentParser;

import java.util.Arrays;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class Algorithms5 {

    public static void main(String[] args) {
        //TODO  1. Написать программу по возведению числа в степень с помощью рекурсии.

        count(3, -4);
        count(5.4, 4);
        count(34, 0);

        //TODO      2. Написать решение для задачи о рюкзаке при помощью рекурсии. За основу взять код из файла Backpack.java

        int[] weight = {2, 3, 3, 4};
        int[] val = {1, 2, 5, 9};
        int w = 7;
        int n = val.length;

        System.out.println("backpack solution: " + Backpack.recursive(weight, val, w, n));
        
        //TODO 3. В парсер выражений из файла RecursiveDescentParser.java добавть возможность вычисления функция sin(n), cos(n), tg(n), ctg(n), ln(n).

        String expr = "tg(22) - ctg(43) + sin(20) + ln(3) * cos(2) + 2.111 * 3.5 + ( 3 + 4 * ( 2.1 + 3 ) - 10 ) * ( 5 - 7 + 4 - 2 ) + 11";
        System.out.println("parsing of string" + expr);
        RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(Arrays.asList(expr.split(" ")));
        System.out.println(recursiveDescentParser.parse());
        System.out.println(tan(22) - (1.0 / tan(43)) + sin(20) + log(3) * cos(2) + 2.111 * 3.5 + (3 + 4 * (2.1 + 3) - 10) * (5 - 7 + 4 - 2) + 11);


    }

    private static void count(double n, double t) {
        double sign = t;
        double sum;
        if (sign < 0) {
            t = -t;
        }
        sum = recCount(n, t);
        if (sign < 0) {
            sum = 1.0 / sum;
        }

        System.out.printf("sum of %f in %f is %f%n", n, t, sum);
    }

    private static double recCount(double n, double t) {
        if (t == 0) {
            return 1;
        }
        return n * recCount(n, t - 1);
    }
}
