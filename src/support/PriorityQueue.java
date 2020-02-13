package support;

public class PriorityQueue {
    private int size;
    private int items;
    private int[] queue;

    public PriorityQueue(int size) {
        this.size = size;
        this.items = 0;
        this.queue = new int[this.size];
    }

    public boolean isEmpty() {
        return (this.items == 0);
    }

    public boolean isFull() {
        return (this.size == this.items);
    }

    public void insert(int item) {
        int i;
        if (this.items == 0) {
            this.queue[items++] = item;
        } else {
            for (i = items - 1; i >= 0; i--) {
                if (item > this.queue[i]) {
                    this.queue[i + 1] = this.queue[i];
                } else {
                    break;
                }
            }
            this.queue[i + 1] = item;
            items++;
        }

    }

    public int remove() {
        return queue[--items];
    }

}
