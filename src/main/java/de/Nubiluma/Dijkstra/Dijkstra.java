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
                if (graph.getEdge(currentNode, t) != null && currentNode != t) {
                    relax(graph, currentNode, t);
                } else {
                    System.out.println("Current node has no neighbors.");
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

        min = todo.iterator().next();

        for (T t: todo){
            T next = todo.iterator().next();

            if (result.get(min).getDistance() > result.get(next).getDistance()){
                min = todo.iterator().next();
            }
        }

        return min;
    }

}
