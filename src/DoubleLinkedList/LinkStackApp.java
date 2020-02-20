package DoubleLinkedList;

public class LinkStackApp {
    public static void main(String[] args) {
        StackList list = new StackList();
        list.push("Ivan",11);
        list.push("Lidia", 44);
        list.push("Andrey", 22);
        list.display();
        while (!list.isEmpty()){
            System.out.println("deleted "+ list.pop());
        }
    }
}
