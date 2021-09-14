package graph.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DirectedGraph<T extends Comparable> extends AbstractGraph{

    public DirectedGraph(){

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
    public List<Vertex> breadthFirstSearch() {
        return super.breadthFirstSearch();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DirectedGraph == false)
            return false;

        DirectedGraph otherGraph = (DirectedGraph) obj;

        if(!adjacentVerticesMap.keySet().equals(otherGraph.adjacentVerticesMap.keySet()))
            return false;

        boolean isEqual = true;
        // Iterate through the hashmap. Since we use LinkedHashmap, it will return in order of insertion.

        Iterator iterator1 = adjacentVerticesMap.values().iterator();
        Iterator iterator2 = otherGraph.adjacentVerticesMap.values().iterator();



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
