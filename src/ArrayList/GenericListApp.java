package ArrayList;

public class GenericListApp {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insert("Artem");
        list.insert("Fedor");
        System.out.println(list.find("Artem"));

        LinkedList<People> linkedList = new LinkedList<>();
        linkedList.insert(new People(16,"Artem"));
        linkedList.insert(new People(33, "Fedor"));
        linkedList.insert(new People(22, "Nata"));
        System.out.println(linkedList.find(new People(33, "Fedor")));
        linkedList.delete();
        linkedList.display();
    }


}
