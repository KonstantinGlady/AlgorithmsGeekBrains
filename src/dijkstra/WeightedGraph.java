package dijkstra;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WeightedGraph {
    private Map<Vertex, List<Edge>> adjmap;

    public WeightedGraph() {
        this.adjmap = new HashMap<>();
    }

    public void addVertex(String label) {
        adjmap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addEdge(String label1, String label2, int weight) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        Edge e1 = new Edge(v1, weight);
        Edge e2 = new Edge(v2, weight);
        adjmap.get(v1).add(e2);
        adjmap.get(v2).add(e1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Edge> ea1 = adjmap.get(v1);
        List<Edge> ea2 = adjmap.get(v2);
        if (ea1 != null) {
            ea1.removeAll(ea1.stream()
                    .filter(edge -> edge.getVertex().equals(v2))
                    .collect(Collectors.toList()));
        }
        if (ea2 != null) {
            ea2.removeAll(ea2.stream()
                    .filter(edge -> edge.getVertex().equals(v1))
                    .collect(Collectors.toList()));
        }
    }


    public Map<Vertex, Integer> dijkstra(String startLabel, String endLabel) {
        Vertex startVertex = new Vertex(startLabel);
        Map<Vertex, Integer> result = adjmap.keySet().stream()
                .collect(Collectors.toMap(vertex -> vertex, vertex -> vertex.equals(startVertex) ? 0 : Integer.MAX_VALUE));
        Map<Vertex, Vertex> prevMap = new HashMap<>();

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(result::get));
        queue.add(startVertex);

        Set<Vertex> settled = new HashSet<>();
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            int currentDist = result.get(currentVertex);
            if (settled.contains(currentVertex)) {
                continue;
            }
            settled.add(currentVertex);
            for (Edge edge : adjmap.get(currentVertex)) {
                Vertex neighbornVertex = edge.getVertex();
                int neigbornDist = result.get(neighbornVertex);
                if (settled.contains(neighbornVertex)) {
                    continue;
                }
                if (neigbornDist == Integer.MAX_VALUE || neigbornDist > currentDist + edge.getWeight()) {
                    result.put(neighbornVertex, currentDist + edge.getWeight());
                    queue.add(neighbornVertex);
                    prevMap.put(neighbornVertex, currentVertex);
                }
            }
        }

        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(endLabel));
        Vertex current = prevMap.get(new Vertex(endLabel));
        while (current != null) {
            stack.push(current);
            current = prevMap.get(current);
        }

        List<Vertex> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }
        System.out.println("path" + path.toString());
        return result;
    }
}
