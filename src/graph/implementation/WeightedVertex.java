package graph.implementation;

public class WeightedVertex<W extends Comparable,T extends Comparable> extends Vertex {

    public W weight;

    public WeightedVertex(Vertex v, W weight) {
        super(v.getValue());
        this.weight = weight;
    }

    public WeightedVertex(T value, W weight) {
        super(value);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(Value: "+getValue()+" , Incident Weight: "+weight+")";
    }
}
