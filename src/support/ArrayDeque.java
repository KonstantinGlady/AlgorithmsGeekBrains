package support;


import java.util.NoSuchElementException;

public class ArrayDeque<E> {
    private E[] array;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque(int size) {
        this.size = size;
        array = (E[]) new Object[this.size];
        this.head = 0;
        this.tail = 0;
    }

    private int inc(int i, int modulus) {
        if (++i >= modulus) {
            i = 0;
        }
        return i;
    }

    private int dec(int i, int modulus) {
        if (--i < 0) {
            i = modulus - 1;
        }
        return i;
    }

    public void addFirst(E e) {
        array[head = dec(head, array.length)] = e;
    }


    public void addLast(E e) {
        array[tail] = e;
        tail = inc(tail, array.length);
    }


    public E removeFirst() {
        E e = array[head];
        if (e == null) {
            throw new NoSuchElementException();
        }
        head = inc(head, array.length);
        return e;
    }


    public E removeLast() {
        int t;
        E e = array[t = dec(tail, array.length)];
        if (e == null) {
            throw new NoSuchElementException();
        }
        if (e != null) {
            array[tail = t] = null;
        }
        return e;
    }
}
