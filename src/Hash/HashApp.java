package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashApp {
    public static void main(String[] args) throws IOException {
        Item aDataItem;
        int aKey, n, size, keysPerCell;
        System.out.print("Enter size of hash table: ");
        size = 10;//getInt();
        System.out.print("Enter initial number of items: ");
        n = 8;//getInt();
        keysPerCell = 10;
        HashTable hashTable = new HashTable(size);
        for (int i = 0; i < n; i++) {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            aDataItem = new Item(aKey);
            hashTable.insert(aDataItem);
        }

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    hashTable.display();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Item(aKey);
                    hashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = hashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could not find :" + aKey);
                        break;
                    }
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
