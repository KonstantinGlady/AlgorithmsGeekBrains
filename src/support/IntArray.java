package support;

import java.util.Arrays;
import java.util.Random;

public class IntArray {
    int size;
    int array[];

    public IntArray() {
        this.size = 10;
        this.array = new int[]{2, 3, 8, 1, 5, 11, 21, 34, 65, 78};
    }

    public IntArray(int size) {
        this.size = 0;
        this.array = new int[size];
    }

    public IntArray(int size, int min, int max) {
        this.size = size;
        //  this.array = new int[size];
        Random rnd = new Random();
      //  for (int i = 0; i < size; i++) {
            this.array = rnd.ints(size, min, max).toArray();
      //  }
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.array[i]);
        }
    }

    @Override
    public String toString() {
        return "IntArray{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public int getElement(int index) {
        return array[index];
    }

    public int getIndex(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.array[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean find(int value) {

        for (int i = 0; i < size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean binaryFind(int value) {
        int hi = this.size - 1;
        int low = 0;
        int mid;

        while (low <= hi) {
            mid = (hi + low) / 2;
            if (value == array[mid]) {
                return true;
            } else {
                if (value < array[mid]) {
                    hi = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    public void insert(int value) {
        this.array[this.size] = value;
        this.size++;
    }

    public void delete(int elem) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (array[i] == elem) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("can`t find element: " + elem);
            return;
        }
        for (int j = index; j < this.size - 1; j++) {
            this.array[j] = this.array[j + 1];
        }
        this.size--;

    }

    public void sortBubble() {
        for (int i = this.size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    change(j, j + 1);
                }
            }
        }
    }

    public void sortSelect() {
        int index;
        for (int i = 0; i < this.size; i++) {
            index = i;
            for (int j = i + 1; j < this.size; j++) {
                if (this.array[j] < this.array[index]) {
                    index = j;
                }
            }
            change(i, index);
        }
    }

    private void change(int j, int i) {
        int temp = this.array[j];
        this.array[j] = this.array[i];
        this.array[i] = temp;

    }

    public void sortInsert() {
        for (int i = 1; i < this.size; i++) {
            int temp = this.array[i];
            int j = i;
            while (j > 0 && this.array[j - 1] >= temp) {
                this.array[j] = this.array[j - 1];
                j--;
            }
            this.array[j] = temp;
        }
    }


}
