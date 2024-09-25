package array_based;

/* This file is a part of implementing a basic stack data structure using Java. 
 * There are two kinds of stack:
 * - array-based stack
 * - linked stack
 * This class uses an array-based stack for an automobile manufacturing assembly line. 
 * 
 * A vehicle must be inspected at three stations: station 0, station 1, and station 2.
 * It must be inspected in the order of 0, 1, 2.
 */

public class ManageAssemblyLine {

	private static final int totalStations = 3; // 3 stations mean a stack of size 3

	public static void main(String[] args) {	
		// create an empty stack with size 3
		CustomStack<Object> remainingInspections = new CustomStack<Object>(totalStations);
		
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