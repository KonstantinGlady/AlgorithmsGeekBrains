package Graphs;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public Vertex prev;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}
