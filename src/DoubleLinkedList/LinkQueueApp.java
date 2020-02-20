package DoubleLinkedList;

public class LinkQueueApp {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.insert("Petr", 23);
        queue.insert("Lena", 54);
        queue.insert("Andrey", 33);
        queue.display();
        while (!queue.isEmpty()){
            System.out.println("deleted " + queue.delete().name);
        }
    }
}
