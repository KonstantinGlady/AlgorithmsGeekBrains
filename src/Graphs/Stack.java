package Graphs;

public class Stack {
    private int top;
    private int[] stack;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.top = -1;
        this.stack = new int[size];
    }

    public void push(int n) {
        stack[++top] = n;
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
