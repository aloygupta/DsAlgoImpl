import graph.MatrixGraph;
import graph.implementation.MatrixUndirectedGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixUndirectedGraphTest {

    //https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/
    MatrixGraph matrixGraph;

    @Before
    public void setUp(){
        matrixGraph = new MatrixUndirectedGraph();
    }

    @Test
    public void testAddVertex(){
        Assert.assertTrue(matrixGraph.addVertex());
        Assert.assertTrue(matrixGraph.addVertex());
        Assert.assertTrue(matrixGraph.addVertex());
        Assert.assertTrue(matrixGraph.addVertex());
        Assert.assertTrue(matrixGraph.addVertex());
    }

    @Test
    public void testRemoveVertex(){
        testAddEdge();

        matrixGraph.removeVertex(4);
        //System.out.println(matrixGraph);
    }

    @Test
    public void testAddEdge(){
        testAddVertex();

        Assert.assertTrue(matrixGraph.addEdge(0,1));
        Assert.assertTrue(matrixGraph.addEdge(0,4));
        Assert.assertTrue(matrixGraph.addEdge(1,3));
        Assert.assertTrue(matrixGraph.addEdge(1,4));
        Assert.assertTrue(matrixGraph.addEdge(3,4));
        Assert.assertTrue(matrixGraph.addEdge(1,2));
        Assert.assertTrue(matrixGraph.addEdge(2,3));
    }

    @Test
    public void testRemoveEdge(){
        testAddEdge();
        //System.out.println(matrixGraph);
        Assert.assertTrue(matrixGraph.removeEdge(1,2));
        //System.out.println(matrixGraph);
    }

    @Test
    public void testIsAdjacent(){
        testAddEdge();
        Assert.assertTrue(matrixGraph.isAdjacent(3,4));
        Assert.assertFalse(matrixGraph.isAdjacent(3,0));
    }

    @Test
    public void testNeighbors(){
        testAddEdge();
        List<Integer> neighbors;

        neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        neighbors.add(3);
        Assert.assertTrue(neighbors.equals(matrixGraph.neighbors(2)));

        neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        neighbors.add(2);
        neighbors.add(4);
        Assert.assertTrue(neighbors.equals(matrixGraph.neighbors(3)));

        neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        neighbors.add(4);
        Assert.assertTrue(neighbors.equals(matrixGraph.neighbors(0)));


    }

    @Test
    public void testBreadthFirstSearch(){

    }
}
