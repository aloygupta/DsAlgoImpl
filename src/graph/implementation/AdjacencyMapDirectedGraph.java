package graph.implementation;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AdjacencyMapDirectedGraph<T extends Comparable> extends AdjacencyMapAbstractGraph {

    public AdjacencyMapDirectedGraph(){

    }

    @Override
    public boolean addVertex(Vertex vertex) {
        adjacentVerticesMap.putIfAbsent(vertex,new ArrayList<T>());
        return true;
    }

    @Override
    public boolean removeVertex(Vertex vertexToRemove) {


        Iterator hmIterator = adjacentVerticesMap.entrySet().iterator();

        // Iterate through the hashmap. Since we use LinkedHashmap, it will return in order of insertion.

        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();

            if(mapElement.getKey().equals(vertexToRemove)){
                // if the key represent vertex, remove the entire mapping itself. That would remove all outbound edges from that key
                adjacentVerticesMap.remove(mapElement.getKey());
            }
            else{
                // remove all edges incident on the vertexToRemove, by going through each vertex's outbound edge list
                List<Vertex> list = (List<Vertex>)mapElement.getValue();

                int size = list.size();
                for(int i=0; i<size; i++){
                    Vertex listVertexElement = list.get(i);
                    if(listVertexElement.equals(vertexToRemove)){
                        list.remove(listVertexElement);
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean addEdge(Vertex vertex1, Vertex vertex2) {
        List<Vertex> adjacentVertices  = (List<Vertex>) adjacentVerticesMap.get(vertex1);
        adjacentVertices.add(vertex2);
        adjacentVerticesMap.put(vertex1,adjacentVertices);

        return true;
    }

    @Override
    public boolean removeEdge(Vertex vertex1, Vertex vertex2) {
        List<Vertex> adjacentVertices  = (List<Vertex>) adjacentVerticesMap.get(vertex1);
        boolean wasRemoved =  adjacentVertices.remove(vertex2);
        adjacentVerticesMap.put(vertex1,adjacentVertices);

        //TODO: Remove All. For multiple edges between two same nodes, with different weights

        return wasRemoved;
    }

    @Override
    public boolean isAdjacent(Vertex vertex1, Vertex vertex2) {
        List<Vertex> adjacentVertices  = (List<Vertex>) adjacentVerticesMap.get(vertex1);

        // if no such vertex1 is present in our directed graph
        if(adjacentVertices == null)
            return false;

        // check if there's a directed edge between them
        boolean isAdjacent =  adjacentVertices.contains(vertex2);

        return isAdjacent;
    }

    @Override
    public List<Vertex> neighbors(Vertex vertex) {
        List<Vertex> adjacentVertices  = (List<Vertex>) adjacentVerticesMap.get(vertex);
        return adjacentVertices;
    }

    @Override
    public T getVertexValue(Vertex vertex) {
        Iterator hmIterator = adjacentVerticesMap.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();

            if (mapElement.getKey().equals(vertex)) {
                // return value of matched vertex
                return (T)((Vertex)mapElement.getKey()).getValue();
            }
        }

        return null;
    }

    @Override
    public void setVertexValue(Vertex vertex, Comparable value) {
        Iterator hmIterator = adjacentVerticesMap.entrySet().iterator();

        // Iterate through the hashmap. Since we use LinkedHashmap, it will return in order of insertion.

        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();

            if(mapElement.getKey().equals(vertex)){
                // remove mapping and insert new one
                List<Vertex> adjacentVertices = (List<Vertex>) adjacentVerticesMap.get(mapElement.getKey());
                adjacentVerticesMap.remove(mapElement.getKey());
                vertex.setValue(value);
                adjacentVerticesMap.put(vertex,adjacentVertices);
            }
            else{
                // remove all edges incident on the vertexToRemove, by going through each vertex's outbound edge list
                List<Vertex> list = (List<Vertex>)mapElement.getValue();

                int size = list.size();
                for(int i=0; i<size; i++){
                    Vertex listVertexElement = list.get(i);
                    if(listVertexElement.equals(vertex)){
                        listVertexElement.setValue(value);
                    }
                }
            }
        }
    }

    @Override
    public List<Vertex> breadthFirstSearch(Vertex startVertex) {
        List<Vertex> vertexTraversalList = new ArrayList<>();

        // Mark all vertices as not visited
        Map<Vertex, Boolean> visited = new ConcurrentHashMap<>();

        // Create a Queue for performing BFS
        LinkedList<Vertex> queue = new LinkedList<>();

        // Mark the starting node as visited. Also enqueue it.
        visited.put(startVertex,true);
        queue.add(startVertex);

        while (queue.size() != 0){
            Vertex dequeuedVertex = queue.poll();

            // Add to traversal list
            vertexTraversalList.add(dequeuedVertex);
            List<Vertex> neighbors = neighbors(dequeuedVertex);

            for(Vertex neighbor: neighbors){
                if(visited.get(neighbor) == null){
                    visited.put(neighbor,true);
                    queue.add(neighbor);
                }
            }
        }
        return vertexTraversalList;
    }

    @Override
    public List<Vertex> depthFirstSearch(Vertex startVertex) {
        List<Vertex> vertexTraversalList = new ArrayList<>();

        // Mark all vertices as not visited
        Map<Vertex, Boolean> visited = new ConcurrentHashMap<>();

        Stack<Vertex> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()){
            Vertex poppedVertex = stack.pop();

            if(visited.get(poppedVertex) == null){
                visited.put(poppedVertex,true);
                vertexTraversalList.add(poppedVertex);
            }

            List<Vertex> neighbors = neighbors(poppedVertex);
            for(Vertex neighbor: neighbors){
                if(visited.get(neighbor) == null){
                    stack.push(neighbor);
                }
            }
        }

        return vertexTraversalList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AdjacencyMapDirectedGraph == false)
            return false;

        AdjacencyMapDirectedGraph otherGraph = (AdjacencyMapDirectedGraph) obj;

        if(!adjacentVerticesMap.keySet().equals(otherGraph.adjacentVerticesMap.keySet()))
            return false;

        boolean isEqual = true;

        Iterator hmIterator = adjacentVerticesMap.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            Vertex thisVertex = (Vertex) mapElement.getKey();

            List<Vertex> thisVertexAdjacentList = (List<Vertex>) mapElement.getValue();

            List<Vertex> otherVertexAdjacentList = (List<Vertex>) otherGraph.adjacentVerticesMap.get(thisVertex);

            isEqual = areTwoAdjacentListEqual(thisVertexAdjacentList,otherVertexAdjacentList);
        }

        return isEqual;
    }

    private boolean areTwoAdjacentListEqual(List<Vertex> thisVertexAdjacentList, List<Vertex> otherVertexAdjacentList) {
        if (thisVertexAdjacentList.size() != otherVertexAdjacentList.size())
            return false;

        for (Vertex vertex : thisVertexAdjacentList) {
            if (!otherVertexAdjacentList.contains(vertex)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String desc = "";

        Iterator hmIterator = adjacentVerticesMap.entrySet().iterator();

        // Iterate through the hashmap. Since we use LinkedHashmap, it will return in order of insertion.

        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();

            desc += mapElement.getKey().toString();

            List<Vertex> list = (List<Vertex>)mapElement.getValue();

            if(!list.isEmpty()){
                desc += " -> ";
            }

            int size = list.size();
            for(int i=0; i<size; i++){
                Vertex vertex = list.get(i);
                desc += vertex;
                if(i != (size-1)){
                    desc +=" ; ";
                }
            }

            if(hmIterator.hasNext()){
                desc += "\n";
            }
        }
        return desc;
    }
}
