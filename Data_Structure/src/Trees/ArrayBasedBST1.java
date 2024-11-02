/* COPY AND EXECUTE THIS CODE IN JELIOT 3 */

/* 
 * This file implements a binary search tree using the fixed array-based approach.
 * It primarily focuses on demonstrating the binary search concept.
 * It implements only the search operation.
 * This tree can get unbalanced.
 * The array is being pre-populated with the integers in the tree in the correct sequence.
 * 
 * You input the integer you want to search.
 */

package Trees;

import java.util.*;
//import jeliot.io.*;	// uncomment this in Jeliot 3

public class ArrayBasedBST1 {

	/* Main method */
	public static void main (String[] args) {
		int iterations;		// this variable counts the number of iterations of search that occur
		int index;			// this variable identifies the node of the tree currently being searched
		int prev;			// this variable will be used to keep track of the 'range' of the branch 
		int searchValue;	// this variable will contain the value we are searching for
		
		// initialize the array
		int  bTree[] = {1, 2, 3, 4, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 24, 25, 26, 27, 28, 29, 30, 33, 34, 35, 36, 37, 38, 39, 40};

	    // output information to the console
	    System.out.print("Enter an integer between 1 and 40 to search for: ");

	    // get input from the user
	    Scanner input = new Scanner(System.in);
	    searchValue = input.nextInt();
	    input.close();
	    
	    iterations = 1;

	    // set the initial midpoint of the array which is the root value
	    index = bTree.length / 2;
	    prev = bTree.length;
	
	    
	    // call the binary search method which is designed to recursively search until the proper value has been found
	    binarySearch(bTree, index, prev, searchValue, iterations);       
	}


	/* Method to perform binary search */
	public static void binarySearch(int[] bTree, int index, int prev, int searchValue, int iterations) {
		// if our search value is smaller then the current position -> search the left branch of the tree
		// 'index' indicates the current node that is being compared with the search value
		// 'prev' is used to help identify the width of the current branch so that we can identify the next branch to follow down
		if (bTree[index] < searchValue) {
			index = (prev - index) / 2 + index;
			iterations++;
			binarySearch(bTree, index, prev, searchValue, iterations);            
		}
		
		// if our search value is larger than the current position -> search the right branch of the tree
		// in each iteration of the search we recursively call binarySearch which searches the next level down in the tree
		else if (bTree[index] > searchValue) {
			prev = index;
			index = index / 2;
			iterations++;
			binarySearch(bTree, index, prev, searchValue, iterations);
		}
		
		//  when the search value is found -> print the number of iterations the search took to the console and exit the binarySearch method
		else {
			System.out.println("Found the value in " + iterations + " iterations");
			return;      
		}
	}

}