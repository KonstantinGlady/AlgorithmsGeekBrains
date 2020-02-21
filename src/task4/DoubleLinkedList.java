package task4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements Iterable<T> {

    //использование <T>  здесь и далее при создании Node и тд. избыточно, проверка идет при добавлении
    // нового элемента на уровне DoubleLinkedList.
    // удобней назвать head и tail, что бы не пересекались с переменными Node.(читабельность кода)
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        size = 0;
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;// реализация следующего и предыдущего элемента, логично делать в классе элемента а не выше в LinkedList.
            this.prev = prev;
        }
    }

    public void insertTail(T value) {
        Node newNode = new Node(value, null, tail);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void insertHead(T value) {
        //TODO реализовать в качестве ДЗ
        Node tmp = new Node(value, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    public T deleteHead() {
        //TODO реализовать в качестве ДЗ
        if(size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.value;
    }

    public T deleteTail() {
        //TODO реализовать в качестве ДЗ
        if (size == 0) {
            throw new NoSuchElementException("size: " + size);
        }
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        return tmp.value;
    }

    //TODO реализовать итератор в качестве ДЗ
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node cur = head;

            @Override
            public boolean hasNext() {
                return (cur != null);
            }

            @Override
            public T next() {
                T tmp = cur.value;
                cur = cur.next;
                return tmp;
            }
        };
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertTail(4);
        list.insertTail(3);
        list.insertTail(2);
        list.insertTail(1);
        list.forEach(System.out::println);
        System.out.println("delete tail");
        list.deleteTail();
        list.forEach(System.out::println);
        System.out.println("insertHead");
        list.insertHead(10);
        list.insertHead(20);
        list.forEach(System.out::println);
        System.out.println("deleteHead");
        list.deleteHead();
        list.forEach(System.out::println);


    }
}
