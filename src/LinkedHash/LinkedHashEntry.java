package LinkedHash;

public class LinkedHashEntry {
    private int key;
    private int value;
    private LinkedHashEntry next;

    public LinkedHashEntry(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }


}
