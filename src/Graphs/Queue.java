package Graphs;

public class Queue {
    private int front;
    private int rear;
    private int items;
    private int size;
    private int[] queue;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[this.size];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    public void insert(int item) {
        if (this.rear == size - 1) {
            this.rear = -1;
        }
        queue[++rear] = item;
        this.items++;
    }

    public int remove() {
        int temp = queue[front++];
        if (front == size) {
            front = 0;
        }
        items--;
        return temp;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (size == items);
    }

    public int peek() {
        return queue[front];
    }
}
