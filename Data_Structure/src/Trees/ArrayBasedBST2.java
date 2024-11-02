/* 
 * This file implements a binary search tree using the dynamic array-based approach.
 * It primarily focuses on demonstrating the dynamic BST with full operations.
 * It uses ArrayList for dynamic sizing.
 * It implements operations to insert, delete, and search.
 * It maintains BST properties during modifications.
 * This tree can get unbalanced.
 * The array is being pre-populated with the integers in the tree in the random sequence.
 * 
 * You do not have to do anything as the code is automated.
 */

package Trees;

import java.util.ArrayList;
import java.util.List;

public class ArrayBasedBST2 {
	
    private List<Integer> elements;
    private int size;

    /* Constructor */
    public ArrayBasedBST2() {
        elements = new ArrayList<>();
        elements.add(null);	// add a null root to simplify index calculations
        size = 0;
    }

    
    /* Insert method */
    public void insert(int element) {
        insertHelper(element, 1);
        size++;
    }

    
    /* Recursive helper method for insert */
    private void insertHelper(int element, int index) {
        while (index >= elements.size()) {
            elements.add(null);
        }
        
        if (elements.get(index) == null) {
            elements.set(index, element);
            return;
        }
        
        if (element < elements.get(index)) {
            insertHelper(element, 2 * index);
        } else if (element > elements.get(index)) {
            insertHelper(element, 2 * index + 1);
        }
    }

    
    /* Remove method */
    public void remove(int element) {
        int index = find(element);
        if (index != -1 && index < elements.size()) {
            removeHelper(index);
            size--;
        }
    }

    
    /* Recursive helper method for remove */
    private void removeHelper(int index) {
        if (index >= elements.size() || elements.get(index) == null) {
            return;
        }
        
        if (isLeaf(index)) {
            elements.set(index, null);
        } else if (getLeft(index) == null) {
            // Only right child
            replaceWithRightSubtree(index);
        } else if (getRight(index) == null) {
            // Only left child
            replaceWithLeftSubtree(index);
        } else {
            // Two children
            int successorIndex = findMin(2 * index + 1);
            if (successorIndex != -1) {
                elements.set(index, elements.get(successorIndex));
                removeHelper(successorIndex);
            }
        }
    }

    
    /* Method to check if a node is a leaf */
    private boolean isLeaf(int index) {
        return getLeft(index) == null && getRight(index) == null;
    }

    
    /* Method to get left child */
    // returns null if out of bounds
    private Integer getLeft(int index) {
        int leftIndex = 2 * index;
        return elements.get(leftIndex);
    }

    
    /* Method to get right child */
    // returns null if out of bounds
    private Integer getRight(int index) {
        int rightIndex = 2 * index + 1;
        return elements.get(rightIndex);
    }

    
    /* Method to replace a node with its right subtree */
    private void replaceWithRightSubtree(int index) {
        elements.set(index, elements.get(2 * index + 1));
        removeHelper(2 * index + 1);
    }

    
    /* Method to replace a node with its left subtree */
    private void replaceWithLeftSubtree(int index) {
        elements.set(index, elements.get(2 * index));
        removeHelper(2 * index);
    }

    
    /* Method to find the minimum value in a subtree */
    private int findMin(int index) {
        while (index < elements.size() && elements.get(index) != null) {
            if (2 * index >= elements.size() || elements.get(2 * index) == null) {
                return index;
            }
            index = 2 * index + 1;
        }
        return -1;
    }

    
    /* Method to find an element in the tree */
    private int find(int element) {
        return findHelper(element, 1);
    }

    
    /* Recursive helper method for find */
    private int findHelper(int element, int index) {
        if (index >= elements.size() || elements.get(index) == null) {
            return -1;
        }
        if (element == elements.get(index)) {
            return index;
        }
        if (element < elements.get(index)) {
            return findHelper(element, 2 * index);
        } else {
            return findHelper(element, 2 * index + 1);
        }
    }

    
    /* Get method (by index) */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getInOrder(1, new int[]{0, index})[0];
    }

    
    /* Recursive helper method for get (in-order traversal) */
    private int[] getInOrder(int nodeIndex, int[] state) {
        if (nodeIndex >= elements.size() || elements.get(nodeIndex) == null) {
            return state;
        }
        
        // traverse left subtree
        state = getInOrder(2 * nodeIndex, state);
        
        // process current node
        if (state[1] == 0) {
            state[0] = elements.get(nodeIndex);
            return state;
        }
        state[1]--;
        
        // traverse right subtree
        return getInOrder(2 * nodeIndex + 1, state);
    }

    
    /* Method to get the size of the tree */
    public int size() {
        return size;
    }

    
    /* Main method */
    public static void main(String[] args) {
    	ArrayBasedBST2 bst = new ArrayBasedBST2();
        int[] values = {10, 5, 12, 3, 1, 13, 7, 2, 4, 14, 9, 8, 6, 11};

        // insert values
        for (int value : values) {
            bst.insert(value);
        }

        System.out.println("BST size: " + bst.size());
        System.out.println("Element at index 5: " + bst.get(5));

        // remove a value
        bst.remove(7);
        System.out.println("BST size after removing 7: " + bst.size());
        
        // try to get an element after removal
        try {
            System.out.println("Element at index 5 after removal: " + bst.get(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds after removal");
        }
    }
    
}