package de.Nubiluma.Dijkstra;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra<T> {

    Set<T> todo;
    List<T> done = new ArrayList<>();
    Map<T, Vertex<T>> result = new HashMap<>();
    private T min;

    public Map<T, Vertex<T>> evaluateDistances(org.jgrapht.Graph<T, DefaultEdge> graph, T start) {

        todo = graph.vertexSet();

        overpredict();
        result.put(start, new Vertex<>(start, 0));

        while (!todo.isEmpty()) {

            T currentNode = min();
            todo.remove(currentNode);
            done.add(currentNode);

            for (T t : todo) {
                // TODO: Hier muss noch die Schleife auf Zeile 36 nachgebaut werden.
            }

            for (int i = 0; i < vertices.size(); i++) {

                if (graph.getEdge(currentNode, vertices.get(i)) != null && currentNode != vertices.get(i)) {
                    relax(graph, currentNode, vertices.get(i));
                } else {
                    System.out.println("Current node has no neighbours.");
                }
            }

        }

        return result;
    }

    public void overpredict() {
        for (T t : todo) {
            result.put(t, new Vertex<>(t, Integer.MAX_VALUE));
        }
    }

    public void relax(Graph<T, DefaultEdge> graph, T u, T v) {
        Vertex<T> vertex = result.get(u);
        int distance = vertex.getDistance();
        double edgeWeight = graph.getEdgeWeight(graph.getEdge(u, v));
        if (result.get(v).getDistance() > (distance + edgeWeight)) {
            vertex.setDistance((distance + edgeWeight));
        }
    }

    public T min() {

        min = todo.get(0); // TODO: kann als todo.iterator().next(); umgeschrieben werden.

        // TODO: Die Schleife muss noch mit einer for (T t: todo) umgebaut werden.
        for (int i = 0; i < todo.size(); i++) {

            T next = todo.get(i);

            if (result.get(min) > result.get(next)) {
                min = todo.get(i);
            }
        }

        return min;
    }

}
