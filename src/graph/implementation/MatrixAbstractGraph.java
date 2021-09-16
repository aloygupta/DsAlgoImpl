package graph.implementation;

import graph.MatrixGraph;

import java.util.List;

public abstract class MatrixAbstractGraph implements MatrixGraph {

    private static final int MAX_NUMBER_OF_VERTICES = 20;
    protected int[][] graphMatrix;
    protected int numberOfVertices;

    public MatrixAbstractGraph(){
        numberOfVertices = 0;
        graphMatrix = new int[MAX_NUMBER_OF_VERTICES][MAX_NUMBER_OF_VERTICES];

        for(int i = 0; i< MAX_NUMBER_OF_VERTICES; i++){

            for(int j = 0; j< MAX_NUMBER_OF_VERTICES; j++){
                graphMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public boolean addVertex() {
        return false;
    }

    @Override
    public boolean removeVertex(int vertexToRemove) {
        return false;
    }

    @Override
    public boolean addEdge(int vertex1, int vertex2) {
        return false;
    }

    @Override
    public boolean removeEdge(int vertex1, int vertex2) {
        return false;
    }

    @Override
    public boolean isAdjacent(int vertex1, int vertex2) {
        return false;
    }

    @Override
    public List<Integer> neighbors(int vertex) {
        return null;
    }


    @Override
    public List<Integer> breadthFirstSearch() {
        return null;
    }
}
