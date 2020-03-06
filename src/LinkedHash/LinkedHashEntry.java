package LinkedHash;

public class LinkedHashEntry {

    private int data;
    private LinkedHashEntry next;

    public LinkedHashEntry(int data) {
        this.data = data;
        this.next = null;
    }

    public int getKey() {
        return data;
    }

    public int getValue() {
        return data;
    }

    public void setValue(int value) {
        this.data = value;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }


}
