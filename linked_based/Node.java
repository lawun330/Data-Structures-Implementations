package linked_based;

/* This file is a part of implementing a basic stack data structure using Java. 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * This class implements an linked stack. 
 */

class Node {
	
	Node ptr;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
}