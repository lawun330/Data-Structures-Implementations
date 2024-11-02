/* COPY AND EXECUTE THIS CODE IN JELIOT 3 */

/* 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * 
 * This file implements an array-based stack.
 * It is a customization of ArrayBasedStack1 to suit the Jeliot 3 environment.
 * 
 * It also solves the "automobile manufacturing assembly line" assignment:
 * >>> A vehicle must be inspected at three stations: station 0, station 1, and station 2.
 * >>> It must be inspected in the order of 0, 1, 2.
 * 
 * You do not have to do anything as the code is automated.
 */

package Stack;

//import jeliot.io.*;	// uncomment this in Jeliot 3

public class ArrayBasedStack2 {

	private static final int defaultSize = 8; // default stack size

	private int maxSize; 		// maximum stack size
	private int pointer;		// index for the top element
	private int [] arrayStack;	// array holding stack

	/* Constructor for default stack size */
	ArrayBasedStack2() {
		this(defaultSize);	// call the following constructor with the default size
	}
	
	
	/* Constructor for user-defined stack size */
	ArrayBasedStack2(int size) {
		maxSize = size;						// set maximum stack size for operations
		pointer = 0;						// index always starts at 0
		this.arrayStack = new int[size];	// create a stack // elements are integer type
	}
	
	
	/* Method to add an element onto the top of the stack */
	public void push(int element) {
		if (pointer == maxSize) {System.out.println("Stack is full");}	// check if the stack has space available
		arrayStack[pointer++] = element;								// else, increment pointer // add a new element
	}
	
	
	/* Method to get the element at the top of the stack */
	public int pop() {
		if (pointer == 0) {System.out.println("Stack is empty");}		// index 0 indicates an empty stack
		return arrayStack[--pointer]; 									// else, return the top element // decrement pointer
	}
	
	
	/* Main method */
	public static void main(String[] args) {
		// create an empty stack with size 3
		ArrayBasedStack2 remainingInspections = new ArrayBasedStack2(3);
		
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