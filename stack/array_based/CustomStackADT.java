package array_based;

/* This file is a part of implementing a basic stack data structure using Java. 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * This interface is an array-based stack ADT (abstract data type). 
 */

public interface CustomStackADT<E> { // elements are type <E>
	
	// an abstract method to clear the stack (reclaim resources)
	public void clear();
	
	// an abstract method to get the number of elements in the stack
	public int length();
		
	// an abstract method to add an element onto the top of the stack
	public void push(E element);
	
	// an abstract method to pop the top element of the stack (print popped element)
	public E pop();
	
}