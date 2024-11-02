/* COPY AND EXECUTE THIS CODE IN JELIOT 3 */

/*
 * This file primarily focuses on demonstrating the merge sort.
 * It is a customization of Mergesort to suit the Jeliot 3 environment.
 * Jeliot version uses:
 * - manual array creation instead of "Arrays.copyOfRange()" function,
 * - "for loop" instead of "for-each loop" to display arrays.
 * 
 * The unsorted array is initialized without any input.
 * 
 * You do not have to do anything as the code is automated.
 */

package sortingAlgorithms;

// import jeliot.io.*;	// uncomment this in Jeliot 3

public class JeliotMergesort {
	
	// a static variable to keep track of exchanges
	private static int exchangeCount = 0;

	/* Method to initiate the sorting process */
	public static void mergeSort(int[] array) {
		// base case -> if the array is null or has 1 or fewer elements, it's already sorted
		if (array == null || array.length <= 1) {
			return;
		}
    
        // calculate the middle index to divide the array
		int mid = array.length / 2;

        // create left and right subarrays based on the middle index
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
     
		// populate the left subarray
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		
		// populate the right subarray
		for (int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];
		}
     
		// recursively sort the left and right subarrays
		mergeSort(left);
		mergeSort(right);
     
		// merge the sorted subarrays
		merge(array, left, right);
	}
	
	
    /* Method to merge two sorted subarrays into a single sorted array */
	private static void merge(int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		
		// compare elements from both subarrays and place the smaller one in the main array
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
				exchangeCount += (left.length - i);	// increment exchange count when an element from the right array is placed
				}
			k++;
		}
		
		// add remaining elements in the left subarray to the main array
		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
     
		// add remaining elements in the right subarray to the main array
		while (j < right.length) {
			array[k] = right[j];
        	j++;
        	k++;
        }
	}
	
	
	/* Main method */
	public static void main(String[] args) {
		// create an unsorted array
		int[] arr1 = {12, 9, 4, 99, 120, 1, 3, 10, 23, 45, 75, 69, 31, 88, 101, 14, 29, 91, 2, 0, 77};

		// before sorting
		System.out.print("unsorted array before merge sort: ");
		printArray(arr1);

		// reset exchange count
		exchangeCount = 0;

		// sorting
		mergeSort(arr1);

		// after sorting
		System.out.print("sorted array before merge sort: ");
		printArray(arr1);
		System.out.println(exchangeCount + " exchanges were made");
	}

	
	/* Method to print arrays */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
        	System.out.print(arr[i] + " ");
        }
		System.out.println();
	}

}