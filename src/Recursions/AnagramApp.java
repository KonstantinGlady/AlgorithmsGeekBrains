package Recursions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
    static int size;
    static char[] arr = new char[4];

    public static void main(String[] args) throws IOException {
        String input = "1234"; //getString();
        size = input.length();

        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i);
        }
        getAnagram(size);
    }

    public static void getAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            getAnagram(newSize-1);
            if (newSize == 2) {
                display();
            }
                rotate(newSize);

        }

    }

    private static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    private static void rotate(int newSize) {
        int i;
        int pos = size - newSize;
        char tmp = arr[pos];
        for (i = pos + 1; i < size; i++) {
            arr[i-1] = arr[i];
        }
        arr[i-1] = tmp;
    }

    private static String getString() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
