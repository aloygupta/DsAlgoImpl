package testclasses;

import stack.Stack;
import stack.implementation.LinkedStack;

public class StackTest {

	public static void main(String[] args) {

		try {
			
		Stack<Integer> stack = new LinkedStack<>();
		//System.out.println("Popped: "+stack.pop());
		//System.out.println(stack.peek());
		System.out.println("Empty? "+stack.empty());
		System.out.println("Size: "+stack.getSize());
		stack.push(32);
		System.out.println("Popped: "+stack.pop());
		System.out.println(stack);
		stack.push(42);
		stack.push(45);
		stack.push(78);
		stack.push(100);
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println("Size: "+stack.getSize());
		
		System.out.println("Popped: "+stack.pop());
		System.out.println("Size: "+stack.getSize());
		System.out.println(stack);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
