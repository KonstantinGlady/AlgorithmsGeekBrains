package DoubleLinkedList;

public class StackList {
    private LinkedList list;

    public StackList() {
        list = new LinkedList();
    }

    public String pop() {
        return list.delete().name;
    }

    public void push(String name, int age) {
        list.insert(name, age);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        list.display();
    }
}
