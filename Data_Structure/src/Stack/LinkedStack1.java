/* 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * 
 * This file implements a linked stack.
 * 
 * It also solves the "automobile manufacturing assembly line" assignment:
 * >>> A vehicle must be inspected at three stations: station 0, station 1, and station 2.
 * >>> It must be inspected in the order of 0, 1, 2.
 * 
 * You do not have to do anything as the code is automated.
 */

package Stack;

class Node {
	Node ptr;
	int value;
	
	/* Constructor */
	public Node(int value) {
		this.value = value;
	}
}


public class LinkedStack1 {
	
	/* Main method */
	public static void main(String[] args) {
		Node link, plink;
		
	    // root will be the beginning of the linked list
	    Node root = new Node(2);
	    
	    // each additional node will link to preceding one
	    link = new Node(1);
	    link.ptr = root;
	    plink = link;

	    link = new Node(0);
	    link.ptr = plink;
	    plink = link;
	   
	    // move through the list and print out each value
	    printList(link);
	} 

	
	/* Utility method to print */
	public static void printList(Node node) {
	  if (node != null) {
		  System.out.println(" Value: " + node.value);
		  printList(node.ptr);	// recursively call itself
	  }
	}

}