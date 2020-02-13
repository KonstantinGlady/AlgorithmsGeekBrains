package support;

public class Queue<T> {
    private int front;
    private int rear;
    private int items;
    private int size;
    private T[] queue;

    public Queue(int size) {
        this.size = size;
        this.queue = (T[]) new Object[this.size];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    public void insert(T item) {
        if (this.rear == size - 1) {
            this.rear = -1;
        }
        queue[++rear] = item;
        this.items++;
    }

    public T remove() {
        T temp = queue[front++];
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

    public T peek() {
        return queue[front];
    }
}
