package sort;

public class SortObject<T extends Comparable<T>> implements Comparable<SortObject<T>> {

    public T actualObjValue;

    public SortObject(T actualObjValue){
        this.actualObjValue = actualObjValue;
    }

    @Override
    public int compareTo(SortObject<T> tSortObject) {
        return this.actualObjValue.compareTo(tSortObject.actualObjValue);
    }
}
