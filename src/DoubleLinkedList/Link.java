package DoubleLinkedList;

public class Link {
    public String name;
    public int age;

    public Link next;

    public Link(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("name " + name + " age " + age);
    }
}
