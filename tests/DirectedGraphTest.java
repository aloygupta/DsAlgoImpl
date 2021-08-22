import graph.Graph;
import graph.implementation.DirectedGraph;
import graph.implementation.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DirectedGraphTest {

    //https://www.log2base2.com/data-structures/graph/adjacency-list-representation-of-graph.html
    Graph<Integer> graph;

    @Before
    public void setUp(){
        graph = new DirectedGraph<>();

      /*  graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));

        graph.addEdge(new Vertex(0),new Vertex(1));
        graph.addEdge(new Vertex(0),new Vertex(2));
        graph.addEdge(new Vertex(0),new Vertex(3));
        graph.addEdge(new Vertex(1),new Vertex(3));
        graph.addEdge(new Vertex(1),new Vertex(4));
        graph.addEdge(new Vertex(2),new Vertex(3));
        graph.addEdge(new Vertex(3),new Vertex(4));*/

    }

    @Test
    public void testAddVertex() {
        graph.addVertex(new Vertex(0));
        Assert.assertEquals("(0)",graph.toString());

        graph.addVertex(new Vertex(1));
        Assert.assertEquals("(0)\n(1)",graph.toString());

        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));

        Assert.assertEquals("(0)\n(1)\n(2)\n(3)\n(4)",graph.toString());

    }

    @Test
    public void testRemoveVertex() {
        testAddEdge();

        graph.removeVertex(new Vertex(4));

        Assert.assertEquals("(0) -> (1) ; (2) ; (3)\n" +
                "(1) -> (3)\n" +
                "(2) -> (3)\n" +
                "(3)",graph.toString());
    }

    @Test
    public void testAddEdge() {
        testAddVertex();

        graph.addEdge(new Vertex(0),new Vertex(1));
        Assert.assertEquals("(0) -> (1)\n" +
                "(1)\n" +
                "(2)\n" +
                "(3)\n" +
                "(4)",graph.toString());

        graph.addEdge(new Vertex(0),new Vertex(2));
        Assert.assertEquals("(0) -> (1) ; (2)\n" +
                "(1)\n" +
                "(2)\n" +
                "(3)\n" +
                "(4)",graph.toString());


        graph.addEdge(new Vertex(0),new Vertex(3));
        graph.addEdge(new Vertex(1),new Vertex(3));
        graph.addEdge(new Vertex(1),new Vertex(4));
        graph.addEdge(new Vertex(2),new Vertex(3));
        graph.addEdge(new Vertex(3),new Vertex(4));

        Assert.assertEquals("(0) -> (1) ; (2) ; (3)\n" +
                "(1) -> (3) ; (4)\n" +
                "(2) -> (3)\n" +
                "(3) -> (4)\n" +
                "(4)",graph.toString());
    }

    @Test
    public void testRemoveEdge() {
        testAddEdge();

        graph.removeEdge(new Vertex(3),new Vertex(4));
        Assert.assertEquals("(0) -> (1) ; (2) ; (3)\n" +
                "(1) -> (3) ; (4)\n" +
                "(2) -> (3)\n" +
                "(3)\n" +
                "(4)",graph.toString());

        graph.removeEdge(new Vertex(0),new Vertex(2));
        Assert.assertEquals("(0) -> (1) ; (3)\n" +
                "(1) -> (3) ; (4)\n" +
                "(2) -> (3)\n" +
                "(3)\n" +
                "(4)",graph.toString());
    }

    @Test
    public void testIsAdjacent() {
      testAddEdge();

      Assert.assertTrue(graph.isAdjacent(new Vertex(0),new Vertex(3)));
      Assert.assertFalse(graph.isAdjacent(new Vertex(0),new Vertex(4)));

      // Since this is directed graph
      Assert.assertTrue(graph.isAdjacent(new Vertex(2),new Vertex(3)));
      Assert.assertFalse(graph.isAdjacent(new Vertex(3),new Vertex(2)));

      Assert.assertFalse(graph.isAdjacent(new Vertex(5),new Vertex(2)));
    }

    @Test
    public void testNeighbors() {
        testAddEdge();

        Assert.assertEquals("[(1), (2), (3)]",graph.neighbors(new Vertex(0)).toString());
        Assert.assertEquals("[(3), (4)]",graph.neighbors(new Vertex(1)).toString());
        Assert.assertEquals("[(3)]",graph.neighbors(new Vertex(2)).toString());
        Assert.assertEquals("[(4)]",graph.neighbors(new Vertex(3)).toString());
        Assert.assertEquals("[]",graph.neighbors(new Vertex(4)).toString());


    }

    @Test
    public void testGetVertexValue() {
        Assert.assertEquals(Integer.valueOf(4),graph.getVertexValue(new Vertex(4)));
        Assert.assertEquals("Java",graph.getVertexValue(new Vertex("Java")));
    }

    @Test
    public void testSetVertexValue() {
        Vertex<Integer> vertex = new Vertex<Integer>(4);
        Assert.assertEquals(Integer.valueOf(4),graph.getVertexValue(vertex));
        graph.setVertexValue(vertex,Integer.valueOf(3));
        Assert.assertEquals(Integer.valueOf(3),graph.getVertexValue(vertex));
    }
}
