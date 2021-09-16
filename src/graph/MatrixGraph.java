package graph;

import graph.implementation.Vertex;

import java.util.List;

public interface MatrixGraph {

    boolean addVertex();

    // removes vertex, if it is there
    boolean removeVertex(int vertexToRemove);

    // adds the edge from the vertex x to the vertex y, if it is not there
    boolean addEdge(int vertex1, int vertex2);

    // removes the edge from the vertex x to the vertex y, if it is there
    boolean removeEdge(int vertex1, int vertex2);

    // tests whether there is an edge from the vertex x to the vertex y
    boolean isAdjacent(int vertex1, int vertex2);

    // lists all vertices y such that there is an edge from the vertex x to the vertex y
    List<Integer> neighbors(int vertex);

    // In Matrix representation, a separate mapping somewhere would be present. So, comment out below two functions
    /*// returns the value associated with the vertex x
    T getVertexValue(int vertex);

    // sets the value associated with the vertex x to v
    void setVertexValue(int vertex, T value);*/

    // perform breadth first search on the graph and return the traversal as a list of vertex, in the order traversed.
    List<Integer> breadthFirstSearch();


    // Weighted Graph
    // returns the value associated with the edge (x, y)
    /*T getEdgeValue(Vertex vertex1,Vertex vertex2);

    // sets the value associated with the edge (x, y) to v
    void setEdgeValue(Vertex vertex1, Vertex vertex2, T value);*/
}
