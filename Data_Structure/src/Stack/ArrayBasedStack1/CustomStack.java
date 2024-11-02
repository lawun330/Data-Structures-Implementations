/* 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * 
 * This file implements an array-based stack.
 * 
 * Three files work together to implement an array-based stack.
 * - CustomStackADT: Abstract Data Type "Stack"
 * - CustomStack: Implementation of Stack ADT
 * - ManageAssemblyLine: Application of Stack Implementation
 * 
 * These files also solve the "automobile manufacturing assembly line" assignment:
 * >>> A vehicle must be inspected at three stations: station 0, station 1, and station 2.
 * >>> It must be inspected in the order of 0, 1, 2.
 * 
 * You do not have to do anything as the code is automated.
 */

package Stack.ArrayBasedStack1;

class CustomStack<E> implements CustomStackADT<E> {	// elements are type <E>

	private static final int defaultSize = 8;		// default stack size

	private int maxSize; 		// maximum stack size
	private int pointer;		// index for the top element
	private E [] arrayStack;	// array holding stack

	/* Constructor for default stack size */
	CustomStack() {
		this(defaultSize);		// call the following constructor with the default size
	}
	
	
	/* Constructor for user-defined stack size */
	@SuppressWarnings("unchecked")				// generic array allocation
	CustomStack(int size) {
		maxSize = size;							// set maximum stack size for operations
		pointer = 0;							// index always starts at 0
		arrayStack = (E[]) new Object[size];	// create a stack // elements are type <E>
	}
	
	
	/* Implementation of an abstract method to clear the stack (reclaim resources) */
	public void clear() {
		pointer = 0;							// reset pointer to index 0
	}
	
	
	/* Implementation of an abstract method to get the number of elements in the stack */
	public int length() {
		return pointer;
	}
	
	
	/* Implementation of an abstract method to add an element onto the top of the stack */
	public void push(E element) {
		assert pointer != maxSize : "Stack is full";	// check if the stack has space available
		arrayStack[pointer++] = element;				// else, increment pointer // add a new element
	}
	
	
	/* Implementation of an abstract method to get the element at the top of the stack */
	public E pop() {
		assert pointer != 0 : "Stack is empty";			// index 0 indicates an empty stack
		return arrayStack[--pointer]; 					// else, return the top element // decrement pointer
	}
	
}