/*
 * This file primarily focuses on demonstrating the shell sort.
 * The unsorted array is initialized without any input.
 * 
 * You do not have to do anything as the code is automated.
 */

package sortingAlgorithms;

class Shellsort {
	
	/* Utility method to print */
	private static void printArray(int array[]) {
		int l = array.length;
		for (int i = 0; i < l; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	
	/* Method to perform the shell sort */
	private int sort(int arr[]) {
		int count = 0;  // variable to keep track of exchanges
		int n = arr.length;
		
		// start with a large gap and reduce it in each iteration
		// the gap starts as n/2 and is divided by 2 in each pass
		for (int takePart = n/2; takePart > 0; takePart /= 2) {
			
			// do a gapped insertion sort for this gap size
			// the first gap elements (array[0..gap-1]) are already in gapped order
			for (int i = takePart; i < n; i += 1) {
				
				// store current element to be inserted in correct position
				int temp = arr[i];
				int j;
				
				// shift earlier gap-sorted elements up until the correct location for "temp" is found
				// compare elements that are "takePart" positions apart
				for (j = i; j >= takePart && arr[j - takePart] > temp; j -= takePart) {
					arr[j] = arr[j - takePart];
				}
				count += 1;		// increment exchange counter
				arr[j] = temp;	// place "temp" in its correct location
			}
		}
		return count;
	}
	
	
	/* Main method */
	public static void main(String args[]) {
		// create an unsorted array
		int arr[] = {12, 9, 4, 99, 120, 1, 3, 10, 23, 45, 75, 69, 31, 88, 101, 14, 29, 91, 2, 0, 77};
		
		// before sorting
		System.out.print("unsorted array before shell sort: ");
		printArray(arr);

		// sorting
		Shellsort ob = new Shellsort();
		int count = ob.sort(arr);
		
		// after sorting
		System.out.print("sorted array after shell sort: ");
		printArray(arr);
		System.out.println(count + " exchanges were made");
	}

}