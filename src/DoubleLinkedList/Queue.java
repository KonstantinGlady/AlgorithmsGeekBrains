package DoubleLinkedList;

public class Queue {
    private LinkedList queue;

    public Queue() {
        queue = new LinkedList();
    }

    public Link delete() {
       return queue.delete();
    }

    public void insert(String name, int age) {
        this.queue.insert(name, age);
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void display(){
        queue.display();
    }
}
