package de.Nubiluma.Dijkstra;


import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;


public class Main {

    public static void main(String[] args) {

        Dijkstra<String> dijkstra = new Dijkstra<>();

        DefaultUndirectedGraph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        dijkstra.evaluateDistances(graph, "LOL");
    }

}
