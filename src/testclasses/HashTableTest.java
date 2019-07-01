package testclasses;

import hashtable.HashTable;
import hashtable.implementation.LinearProbingHashTable;

public class HashTableTest {

	public static void main(String[] args) {
		
		HashTable<String, Integer> hashtable = new LinearProbingHashTable<>();
		try {
			//hashtable.add(null, 34);
			//hashtable.exists(null);
			//hashtable.get(null);
			//hashtable.remove(null);
			//hashtable.remove("Aloy");
			
			hashtable.add("Aloy", 12);
			System.out.println(hashtable);
			hashtable.add("Gupta", 32);
			System.out.println(hashtable);
			// test updation of value for key 
			hashtable.add("Aloy", 99);
			System.out.println(hashtable);
			hashtable.add("Denmark", 55);
			System.out.println(hashtable);
			hashtable.add("Germany", 80); // collision
			System.out.println(hashtable);
			hashtable.add("Sweden", 84);
			System.out.println(hashtable);
			hashtable.add("Norway", 12); // collision
			System.out.println(hashtable);
			hashtable.add("India", 47); // collision
			System.out.println(hashtable);
			hashtable.add("Canada", 21); // collision
			System.out.println(hashtable); 
			hashtable.add("Spain", 60);	// collision
			System.out.println(hashtable);
			hashtable.add("Egypt", 90);
			System.out.println(hashtable);
			
			//hashtable.add("Brazil", 55); //this will fail, as it will run out of space with size 10
			
			System.out.println("Pakistan exists? "+hashtable.exists("Pakistan"));
			System.out.println("Sweden exists? "+hashtable.exists("Sweden"));
			System.out.println("Value of key Pakistan "+hashtable.get("Pakistan"));
			System.out.println("Value of key Sweden "+hashtable.get("Sweden"));
			
			//System.out.println("Trying to Delete Pakistan");
			//hashtable.remove("Pakistan");
			
			System.out.println("Deleting Norway");
			hashtable.remove("Norway");
			System.out.println(hashtable);
			
			//System.out.println("Trying to re delete Norway."); // this will throw exception
			//hashtable.remove("Norway");
			
			System.out.println("Reinserting Norway");
			hashtable.add("Norway", 65);
			System.out.println(hashtable);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
	}

}
