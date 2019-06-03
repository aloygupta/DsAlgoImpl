package testclasses;

import list.List;
import list.implementation.LinkedListWithOutTail;
import list.implementation.LinkedListWithTail;

public class ListTest {

	public static void main(String[] args) {
		
		try {
			
		List<Integer> myList = new LinkedListWithOutTail<>();
		System.out.println("Empty? : "+myList.empty());
		
		//myList.removeValue(6);
		//myList.reverse();
		//myList.popBack();
		//myList.front();
		//myList.back();
		
		//myList.pushFront(3);
		myList.pushBack(3);
		System.out.println("value at 0: "+myList.valueAt(0));
		//myList.popBack();
		//myList.reverse();
		//System.out.println(myList.toString());
		myList.pushBack(8);
		myList.pushBack(1);
		myList.pushBack(9);
		myList.pushBack(0);
		myList.pushBack(2);
		myList.pushBack(1);
		
		System.out.println(myList.toString());
		
		System.out.println("Size: "+myList.size());
		
		System.out.println("Empty? : "+myList.empty());
		
		System.out.println("Value at index 2: "+myList.valueAt(2));
		//System.out.println("Value at index 2: "+myList.valueAt(-1));
		//System.out.println("Value at index 2: "+myList.valueAt(7));
		
		myList.pushFront(10);
		System.out.println("After pushing front: "+myList.toString());
		
			System.out.println("Pop front: "+myList.popFront());
			System.out.println("After pooping front: "+myList.toString());
		
		
		myList.pushBack(7);
		System.out.println("After push back 7: "+myList.toString());
		
			System.out.println("After pop back: "+myList.popBack());
			System.out.println(myList.toString());
			
			
			System.out.println("Front node value: "+myList.front());
			System.out.println(myList.toString());
			
			System.out.println("Back node value: "+myList.back());
			System.out.println(myList.toString());
			
			//myList.insert(-1, 9);
			//myList.insert(myList.size(), 87);
			myList.insert(myList.size()-1,3);
			System.out.println("After inserting 3 at index : "+(myList.size()-2)+myList.toString());
			
			//myList.erase(-1);
			//myList.erase(myList.size()-1);
			myList.erase(3);
			System.out.println("After erasing value at index 3: "+myList.toString());
			
			//myList.valueNFromEnd(-1);
			//myList.valueAt(myList.size());
			System.out.println("Index 1 value from end: "+myList.valueNFromEnd(1));
			
			
			myList.reverse();
			System.out.println("After reversing list: "+myList.toString());
			
			//myList.removeValue(100);
			myList.removeValue(1);
			System.out.println("After removing first occurence of 1 from list: "+myList.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//System.out.println(myList.toString());
		
	}

}
