package graph.implementation;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>>{

    private int id;
    private T value;

    private Vertex(){

    }

    public Vertex(T value) {
        this.id = value.hashCode();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(Vertex<T> other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Vertex){

            Vertex otherNode = (Vertex<T>)obj;
            if((this.id == otherNode.id))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "("+value+")";
    }
}
