package de.Nubiluma.Dijkstra;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import sun.security.provider.certpath.Vertex;

import java.util.*;

public class Dijkstra {

    List<Vertex> todo;
    List<Vertex> done = new ArrayList<>();
    HashMap<Vertex, Integer> result = new HashMap<>();
    private Vertex currentNode;
    private Vertex min;
    List<DefaultEdge> edges;
    private org.jgrapht.Graph<Vertex, DefaultEdge> graph;


    public HashMap<Vertex, Integer> evaluateDistances(org.jgrapht.Graph<Vertex, DefaultEdge> graph, Vertex start){

        this.graph = graph;
        graph = new DefaultUndirectedWeightedGraph<>(DefaultEdge.class);
        todo = new ArrayList<>(graph.vertexSet());
        edges = new ArrayList<>(graph.edgeSet());

        overpredict();
        result.put(start, 0);

        while (!todo.isEmpty()){

            currentNode = min();
            todo.remove(currentNode);
            done.add(currentNode);

            List<Vertex> vertices = new ArrayList<>(graph.vertexSet());

            for (int i = 0; i < vertices.size(); i++) {

                if (graph.getEdge(currentNode, vertices.get(i)) != null && currentNode != vertices.get(i)){
                    relax(currentNode, vertices.get(i));
                } else {
                    System.out.println("Current node has no neighbours.");
                }
            }

        }

        return result;
    }

    public void overpredict(){

        for (int i = 0; i < todo.size(); i++) {
            currentNode = todo.get(i);
            result.put(currentNode, Integer.MAX_VALUE);
        }
    }

    public void relax(Vertex u, Vertex v){

        if(result.get(v) > (result.get(u) + graph.getEdgeWeight(graph.getEdge(u, v)))){
            result.put(v, (int) (result.get(u) + graph.getEdgeWeight(graph.getEdge(u, v)))); //double??
        }
    }

    public Vertex min(){

        min = todo.get(0);

        for (int i = 0; i < todo.size(); i++){

            Vertex next = todo.get(i);

            if(result.get(min) > result.get(next)){
                min = todo.get(i);
            }
        }

        return min;
    }

}
