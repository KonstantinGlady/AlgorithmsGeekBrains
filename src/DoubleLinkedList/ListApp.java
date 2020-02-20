package DoubleLinkedList;

public class ListApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("Vova", 25);
        list.insert("Sergey", 11);
        list.insert("Marina", 32);
        list.display();
        System.out.println("delet element");
        list.delete("Vova");
        list.display();
    }
}
