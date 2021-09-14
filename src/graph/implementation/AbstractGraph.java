package graph.implementation;

import graph.Graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractGraph<T extends Comparable<T>> implements Graph<T> {

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
    public List<Vertex> breadthFirstSearch(Vertex startVertex) {
        return null;
    }

    @Override
    public List<Vertex> depthFirstSearch(Vertex startVertex) {
        return null;
    }
}
