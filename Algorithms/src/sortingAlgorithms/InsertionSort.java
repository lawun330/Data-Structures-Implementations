/*
 * This file primarily focuses on demonstrating the insertion sort.
 * The unsorted array is initialized without any input.
 * 
 * You do not have to do anything as the code is automated.
 */

package sortingAlgorithms;

public class InsertionSort {

	/* Method to repeatedly insert a new element into the sorted portion of the array */
	public static int insertionSort(int array[]) {  
		int exchanges = 0; // variable to keep track of exchanges
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ( (i > -1) && ( array [i] > key ) ) { 
				array [i + 1] = array [i];
				exchanges++; // increment counter when we make an exchange
				i--;
			}
			array[i + 1] = key;
		}
		return exchanges;
	}

	
	/* Main method */
	public static void main(String a[]) {
		// create an unsorted array
		int[] arr1 = {12, 9, 4, 99, 120, 1, 3, 10, 23, 45, 75, 69, 31, 88, 101, 14, 29, 91, 2, 0, 77};
		
		// before sorting
	    System.out.print("unsorted array before insertion sort: ");
	    for(int i : arr1) {
	    	System.out.print(i + " ");
	    }
	    System.out.println();
	    
	    // sorting
	    int exchanges = insertionSort(arr1);
	    
	    // after sorting
	    System.out.print("sorted array after insertion sort: ");
	    for(int i : arr1) { 
	    	System.out.print(i+" ");
	    }
	    System.out.println("\n" + exchanges + " exchanges were made");
	 }

}