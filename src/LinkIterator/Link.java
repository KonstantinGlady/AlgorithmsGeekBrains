package LinkIterator;

public class Link {
    private String name;
    private int age;

    public Link next;

    public Link(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("name " + name + " age " + age);
    }

    public String getName() {
        return name;
    }
}
