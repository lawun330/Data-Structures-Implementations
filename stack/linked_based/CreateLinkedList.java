package linked_based;

/* This file is a part of implementing a basic stack data structure using Java. 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * This class uses a linked stack for an automobile manufacturing assembly line. 
 * 
 * A vehicle must be inspected at three stations: station 0, station 1, and station 2.
 * It must be inspected in the order of 0, 1, 2.
 */

public class CreateLinkedList {
	
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
	   
	    // Move through the list and print out each value
	    printList(link);
	} 

	public static void printList(Node node) {
	  if (node != null) {
		  System.out.println(" Value: " + node.value);
		  printList(node.ptr); // recursively call itself
	  }
	}

}