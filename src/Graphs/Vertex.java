package Graphs;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public Vertex prev;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    public Vertex getPrev() {
        return prev;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }
}
