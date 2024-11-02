/* 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * 
 * This interface implements an abstract array-based stack.
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

public interface CustomStackADT<E> {	// elements are type <E>
	
	/* Abstract method to clear the stack (reclaim resources) */
	public void clear();
	
	
	/* Abstract method to get the number of elements in the stack */
	public int length();
	
	
	/* Abstract method to add an element onto the top of the stack */
	public void push(E element);
	
	
	/* Abstract method to pop the top element of the stack (print popped element) */
	public E pop();
	
}