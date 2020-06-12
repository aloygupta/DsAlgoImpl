package testclasses;

import java.util.ArrayList;

import array.Vector;
import array.vector.VectorImplementation;

public class VectorTest {

	public static void main(String[] args) {
		Vector<Integer> vector = new VectorImplementation<>(12);
		System.out.println(vector);
		System.out.println("isEmpty "+vector.isEmpty());
		
		for(int i =1; i<=vector.capacity();i++) {
			vector.push(i);
		}
		
		System.out.println("size "+vector.size());
		System.out.println("capacity "+vector.capacity());
		
		vector.push(99);
	
		System.out.println("size "+vector.size());
		System.out.println("capacity "+vector.capacity());
		
		try {
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			
			System.out.println("size "+vector.size());
			System.out.println("capacity "+vector.capacity());
			
			System.out.println("Popped: "+vector.pop());
			
			System.out.println("size "+vector.size());
			System.out.println("capacity "+vector.capacity());
			
			System.out.println("isEmpty "+vector.isEmpty());
			System.out.println(vector);
			
			System.out.println("atIndex 2 "+vector.at(2));
			
			System.out.println("insert -5 at 1 ");
			vector.insert(1, -5);
			System.out.println(vector);
			
			System.out.println("prepend 100");
			vector.prepend(100);
			System.out.println(vector);
			
			System.out.println("delete 0");
			vector.delete(0);
			System.out.println(vector);
			
			System.out.println("push 2");
			vector.push(2);
			System.out.println(vector);
			System.out.println("remove 2");
			vector.remove(2);
			System.out.println(vector);
			
			System.out.println("find index of 3 "+vector.find(3));

			System.out.println("Popped: "+vector.pop());
			System.out.println("Popped: "+vector.pop());
			//System.out.println("Popped: "+vector.pop());
			System.out.println("Size: "+vector.size());
			System.out.println("isEmpty "+vector.isEmpty());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
