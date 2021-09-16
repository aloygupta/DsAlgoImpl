package graph.implementation;

import graph.AdjacencyMapGraph;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AdjacencyMapAbstractGraph<T extends Comparable<T>> implements AdjacencyMapGraph<T> {

    protected Map<Vertex<T>, List<Vertex<T>>> adjacentVerticesMap = new ConcurrentHashMap<>();

    @Override
    public boolean addVertex(Vertex vertex) {
        return false;
    }

    @Override
    public boolean removeVertex(Vertex vertex) {
        return false;
    }

    @Override
    public boolean addEdge(Vertex vertex1, Vertex vertex2) {
        return false;
    }

    @Override
    public boolean removeEdge(Vertex vertex1, Vertex vertex2) {
        return false;
    }

    @Override
    public boolean isAdjacent(Vertex vertex1, Vertex vertex2) {
        return false;
    }

    @Override
    public List<Vertex> neighbors(Vertex vertex) {
        return null;
    }

    @Override
    public T getVertexValue(Vertex vertex) {
        return null;
    }

    @Override
    public void setVertexValue(Vertex vertex, T value) {

    }

    @Override
    public List<Vertex> breadthFirstSearch() {
        return null;
    }
}
