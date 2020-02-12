package support;

public class Stack<T> {
   private T[] stack;
   private int top;
   private int size;

    public Stack(int size) {
        this.size = size;
        this.top = -1;
        this.stack = (T[]) new Object[this.size];
    }

    public T pop() {
        return this.stack[this.top--];
    }

    public void push(T item) {
        this.stack[++this.top] = item;
    }

    public T peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.size - 1 == this.top);
    }
}
