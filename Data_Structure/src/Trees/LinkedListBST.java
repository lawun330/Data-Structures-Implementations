/* 
 * This file implements a binary search tree using the linked (node-based) approach.
 * It primarily focuses on demonstrating the pointer-based BST implementation.
 * It implements operations to insert and search.
 * This tree can get unbalanced.
 * 
 * You can enter inputs larger than 0 to add nodes.
 * Once an input is 0 or less, the search operation begins.
 */

package Trees;

import java.util.*;

class btreeNode {
    btreeNode left;
    btreeNode right;
    int value;
    
    /* Constructor */
    public btreeNode(int value) {
        this.value = value;
    }
}


public class LinkedListBST {

	/* Main method */
    public static void main(String[] args) {
        btreeNode root;
        int treeValue;
        int searchValue;
        int iterations;

        iterations = 0;
        root = null;
        Scanner input = new Scanner(System.in);
        
        // build binary tree by adding nodes to tree structure, then search for item in tree
        do {
            System.out.print("Enter value to populate tree with: ");
            treeValue = input.nextInt();
            
            if (treeValue > 0) {
                if (root != null) {
                    addNode(root, treeValue);                  
                } else {
                    root = new btreeNode(treeValue);
                }
            }
        } while(treeValue > 0);
        
        System.out.print("Enter search value : ");
        searchValue = input.nextInt();   
        iterations = findNode(root, searchValue, iterations);
        if (iterations == 0) {
            System.out.println(">>>Search value not found");
        } else {
            System.out.println(">>>Value found in " + iterations + " iterations");
        }
        input.close();
    }


    /* Method to find a value in the tree */
    public static int findNode(btreeNode node, int value, int iter) {
        if (node != null) {
                if (value == node.value) {
                iter +=1;
            } else if ( value < node.value) {
                iter += 1;
                iter = findNode(node.left, value, iter);
            } else {
                iter += 1;
                iter = findNode(node.right, value, iter);    
            }
        }
        return(iter);
    }


    /* Insert method to add a node to the tree */
    public static void addNode(btreeNode node, int value) {
        if (value < node.value) {
              if (node.left != null) {
                addNode(node.left, value);
              } else {
                System.out.println(">>>Inserted " + value + " to left of " + node.value);
                node.left = new btreeNode(value);
              }
        } else if (value > node.value) {
              if (node.right != null) {
                addNode(node.right, value);
              } else {
                System.out.println(">>>Inserted " + value + " to right of " + node.value);
                node.right = new btreeNode(value);
              }
        }
    }

}