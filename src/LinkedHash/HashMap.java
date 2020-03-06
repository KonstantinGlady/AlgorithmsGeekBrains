package LinkedHash;


public class HashMap<T extends Integer> {
    private final int SIZE;
    private LinkedHashEntry[] table;

    public HashMap(int SIZE) {
        this.SIZE = SIZE;
        table =new LinkedHashEntry[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = null;
        }
    }

    public void add(T value) {

        int item = value;
        int doubleHash = getDoubleHash( item);
        int hash = getHash(doubleHash);
        if (table[hash] == null) {
            table[hash] = new LinkedHashEntry( item);
        } else {
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != item) {
                entry = entry.getNext();
            }
            if (entry.getKey() == item) {
                entry.setValue(item);
            } else {
                entry.setNext(new LinkedHashEntry(item));
            }
        }
    }

    private int getDoubleHash(int key){
        return 5 - key % 5;
    }
    private int getHash(int key) {
        return key % SIZE;
    }

    public void remove(T value) {
        int item = value;
        int doubleHash = getDoubleHash(item);
        int hash = getHash(doubleHash);
        if (table[hash] != null) {
            LinkedHashEntry prev = null;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != item) {
                prev = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == item) {
                if (prev == null) {
                    table[hash] = entry.getNext();
                } else {

                    prev.setNext(entry.getNext());
                }
            }
        }
    }

    public boolean contains(T value) {
        int item = value;
        int doubleHash = getDoubleHash(item);
        int hash = getHash(doubleHash);
        if (table[hash] == null) {
            return false;
        } else {

            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != item) {
                entry = entry.getNext();
            }
            if (entry == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            LinkedHashEntry entry = table[i];
            if (entry == null) {
                System.out.println("null");
            } else {
                System.out.print(entry.getKey() + " -> ");
                while (entry.getNext() != null) {
                    entry = entry.getNext();
                    System.out.print(entry.getKey() + " ");
                }
                System.out.println(" ; ");
            }
        }
    }

}