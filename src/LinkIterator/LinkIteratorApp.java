package LinkIterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkIterator  iterator = new LinkIterator(list);
        iterator.insertAfter("Alex",22);
        iterator.insertAfter("Serg",23);
        list.display();
        iterator.deleteCurrent();
        list.display();
    }
}
