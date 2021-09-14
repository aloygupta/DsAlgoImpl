package graph;

import graph.implementation.Vertex;

import java.util.List;

public interface Graph<T extends Comparable> {

    boolean addVertex(Vertex vertex);

    // removes vertex, if it is there
    boolean removeVertex(Vertex vertexToRemove);

    // adds the edge from the vertex x to the vertex y, if it is not there
    boolean addEdge(Vertex vertex1, Vertex vertex2);

    // removes the edge from the vertex x to the vertex y, if it is there
    boolean removeEdge(Vertex vertex1, Vertex vertex2);

    // tests whether there is an edge from the vertex x to the vertex y
    boolean isAdjacent(Vertex vertex1, Vertex vertex2);

    // lists all vertices y such that there is an edge from the vertex x to the vertex y
    List<Vertex> neighbors(Vertex vertex);

    // returns the value associated with the vertex x
    T getVertexValue(Vertex vertex);

    // sets the value associated with the vertex x to v
    void setVertexValue(Vertex vertex, T value);

    // perform breadth first search on the graph and return the traversal as a list of vertex, in the order traversed.
    List<Vertex> breadthFirstSearch();


    // Weighted Graph
    // returns the value associated with the edge (x, y)
    /*T getEdgeValue(Vertex vertex1,Vertex vertex2);

    // sets the value associated with the edge (x, y) to v
    void setEdgeValue(Vertex vertex1, Vertex vertex2, T value);*/

}
