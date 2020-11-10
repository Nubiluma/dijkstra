package de.Nubiluma.Dijkstra;

public class Vertex<T> {

    private T name;
    private int distance;

    public Vertex(T name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public T getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(double newDistance) {
        this.distance = (int) newDistance;
    }
}
