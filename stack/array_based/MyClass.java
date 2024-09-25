/* COPY AND EXECUTE THIS CLASS IN JELIOT 3 */

package array_based;

// import jeliot.io.*;

/* This file is a combination of three other files for Jeliot 3.
 * It implements a basic stack data structure using Java. 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * This class implements an array-based stack and uses it for an automobile manufacturing assembly line. 
 * 
 * A vehicle must be inspected at three stations: station 0, station 1, and station 2.
 * It must be inspected in the order of 0, 1, 2.
 */

public class MyClass {

	private static final int defaultSize = 8; // default stack size

	private int maxSize; 		// maximum stack size
	private int pointer;		// index for the top element
	private int [] arrayStack;	// array holding stack

	// constructor for default stack size
	MyClass() {
		this(defaultSize);	// call the following constructor with the default size
	}
	
	// constructor for user-defined stack size
	MyClass(int size) {
		maxSize = size;									// set maximum stack size for operations
		pointer = 0;									// index always starts at 0
		this.arrayStack = new int[size];				// create a stack // elements are integer type
	}
	
	// method to add an element onto the top of the stack
	public void push(int element) {
		if (pointer == maxSize) {System.out.println("Stack is full");}	 // check if the stack has space available
		arrayStack[pointer++] = element;				// else, increment pointer // add a new element
	}
	
	// method to get the element at the top of the stack
	public int pop() {
		if (pointer == 0) {System.out.println("Stack is empty");}		// index 0 indicates an empty stack
		return arrayStack[--pointer]; 					// else, return the top element // decrement pointer
	}
	
	// main
	public static void main(String[] args) {
		
		// create an empty stack with size 3
		MyClass remainingInspections = new MyClass(3);
		
		// LIFO stack structure requires pushing 2, 1, 0 to achieve the order 0, 1, 2
		remainingInspections.push(2);
		remainingInspections.push(1);
		remainingInspections.push(0);
		
		// first testing station -> do the first inspection -> this inspection is done
		System.out.println(remainingInspections.pop());
		
		// second testing station -> do the second inspection -> this inspection is done
		System.out.println(remainingInspections.pop());
		
		// third testing station -> do the third inspection -> this inspection is done
		System.out.println(remainingInspections.pop());
		
	}

}