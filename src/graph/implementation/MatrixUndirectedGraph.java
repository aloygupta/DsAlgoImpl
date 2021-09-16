package graph.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixUndirectedGraph<T extends Comparable> extends MatrixAbstractGraph  {

    public MatrixUndirectedGraph(){
        super();
    }

    @Override
    public boolean addVertex() {
        ++numberOfVertices;
        for(int i = 0; i<numberOfVertices; i++){
            graphMatrix[i][numberOfVertices-1] = 0;
            graphMatrix[numberOfVertices-1][i] = 0;
        }

        return true;
    }

    @Override
    public boolean removeVertex(int vertexToRemove) {

        if(!withinGraph(vertexToRemove))
            return false;

        // if it's last row/column, just decrement count and return
        if(vertexToRemove == (numberOfVertices-1)){
            --numberOfVertices;
            return true;
        }

        // Loop till last row/column -1
        while(vertexToRemove < (numberOfVertices-1)){
            for(int i=0; i<numberOfVertices; i++){
                graphMatrix[i][vertexToRemove] = graphMatrix[i][vertexToRemove+1];
            }

            for(int i=0; i<numberOfVertices;i++){
                graphMatrix[vertexToRemove][i] = graphMatrix[vertexToRemove+1][i];
            }

            vertexToRemove++;
        }

        -- numberOfVertices;
        return true;
    }

    @Override
    public boolean addEdge(int vertex1, int vertex2) {

        if(!withinGraph(vertex1))
            return false;

        if(!withinGraph(vertex2))
            return false;

        // not permitting self loops
        if(vertex1 == vertex2)
            return false;

        graphMatrix[vertex1][vertex2] = 1;
        graphMatrix[vertex2][vertex1] = 1;

        return true;
    }

    @Override
    public boolean removeEdge(int vertex1, int vertex2) {

        if(!withinGraph(vertex1))
            return false;

        if(!withinGraph(vertex2))
            return false;

        // self loops not expected
        if(vertex1 == vertex2)
            return false;

        graphMatrix[vertex1][vertex2] = 0;
        graphMatrix[vertex2][vertex1] = 0;

        return true;
    }

    @Override
    public boolean isAdjacent(int vertex1, int vertex2) {

        if(!withinGraph(vertex1))
            return false;

        if(!withinGraph(vertex2))
            return false;

        // self loops not expected
        if(vertex1 == vertex2)
            return false;

        if(graphMatrix[vertex1][vertex2] == 1)
            return true;
        else
            return false;

    }

    @Override
    public List<Integer> neighbors(int vertex) {

        List<Integer> neighbors = new ArrayList<>();

        if(!withinGraph(vertex))
            return null;

        // In Undirected graph, edge representation would be symmetrical. So, just checking one dimension is enough
        for(int j =0 ;j<numberOfVertices; j++){
            if(graphMatrix[vertex][j] == 1)
                neighbors.add(j);
        }

        return neighbors;
    }

    @Override
    public List<Integer> breadthFirstSearch() {
        return super.breadthFirstSearch();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MatrixUndirectedGraph == false)
            return false;

        MatrixUndirectedGraph otherGraph = (MatrixUndirectedGraph) obj;

       return Arrays.deepEquals(graphMatrix,otherGraph.graphMatrix);
    }

    @Override
    public String toString() {
        String toString = "";

        for(int i=0; i< numberOfVertices; i++){

            for(int j=0; j<numberOfVertices; j++){
                toString = toString + graphMatrix[i][j];

                if(j!= (numberOfVertices-1)){
                    toString += " ";
                }
            }
            toString += "\n";
        }

        return toString;
    }

    private boolean withinGraph(int vertex){
        // permitted range is 0 to numberOfVertices-1
        if(vertex<0 || vertex >= numberOfVertices)
            return false;

        return true;
    }
}
