package testclasses;

import array.Vector;
import array.vector.VectorImplementation;
import heap.Heap;
import heap.implementation.ArrayHeap;

public class HeapTest {

    public static void main(String[] args) {
        try{

            Heap<Integer> heap = new ArrayHeap<>();
            System.out.println("IsEmpty: "+heap.isEmpty());
            heap.insert(5);
            heap.insert(10);
            heap.insert(3);
            heap.insert(2);
            heap.insert(20);
            heap.insert(4);
            // expected: 20,10,4,2,5,3
            System.out.println(heap.toString());
            System.out.println("Size: "+heap.getSize());
            System.out.println("IsEmpty: "+heap.isEmpty());
            System.out.println("GetMax: "+heap.getMax());
            System.out.println(heap.toString());
            System.out.println("ExtractMax: "+heap.extractMax());
            System.out.println(heap.toString());
            System.out.println("Size: "+heap.getSize());
            System.out.println("Remove index 1 value: "+heap.remove(1,Integer.MAX_VALUE));
            System.out.println(heap.toString());
            System.out.println("Size: "+heap.getSize());
            System.out.println("Heapify: ");
            heap.heapify();
            System.out.println(heap.toString());

            System.out.println("------------");

            Vector<Integer> vector = new VectorImplementation<>();
            vector.push(3);
            vector.push(8);
            vector.push(1);
            vector.push(10);
            vector.push(6);
            vector.push(2);
            vector.push(5);
            System.out.println("Vector: "+vector.toString());
            Heap<Integer> heap1 = new ArrayHeap<>(vector);
            System.out.println("After heapify: "+heap1.toString());
            System.out.println("Size: "+heap1.getSize());

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
