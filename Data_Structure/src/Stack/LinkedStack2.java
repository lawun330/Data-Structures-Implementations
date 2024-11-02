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

class StackNode {
    StackNode ptr;
    int value;
    
    /* Constructor */
    public StackNode(int value) {
        this.value = value;
    }
}


public class LinkedStack2 {
	
	/* Main method */
    public static void main(String[] args) {
        StackNode link;

        link = null;

        link = push(link, 0);
        System.out.println("Pushed on stack Value: " + link.value);
        
        link = push(link, 1);
        System.out.println("Pushed on stack Value: " + link.value);
        
        link = push(link, 2);
        System.out.println("Pushed on stack Value: " + link.value);

        System.out.println("Pop from Stack Value: " + link.value);
        link = pop(link);
        
        System.out.println("Pop from Stack Value: " + link.value);
        link = pop(link);
        
        System.out.println("Pop from Stack Value: " + link.value);
        link = pop(link);
    }

        
    /* Method to push items onto the stack */
    public static StackNode push(StackNode node, int value) {
        StackNode nnode;
        
        if (node != null) {
            nnode = new StackNode( value );
            nnode.ptr = node;
        } else {
            nnode = new StackNode( value);
            nnode.ptr = null;
        }
        return(nnode);
    }

    
    /* Method to pop items from the stack */
    public static StackNode pop(StackNode node) {
        if (node != null) {
            return(node.ptr);
        } else
            System.out.println("Nothing on the stack");
        return(null);
    }
    
}