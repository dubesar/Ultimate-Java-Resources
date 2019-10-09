import java.util.*;

/*
 * Given a singly linked list we will return the midpoint
 * looping once with two pointers
 * Two Pointer Example begins on line 47
 * More information on Linked Lists:
 * (https://www.geeksforgeeks.org/linked-list-set-1-introduction/)
 */ 

class LLNode {
	// Member Variables
	private int val;
	private LLNode next;

	// Constructor that sets val
	public LLNode(int val){
		this.val = val;
	}

	// Constructor
	// given an int array, create linked list in order of array
	// this = head of linked list
	public LLNode(int[] arrToLLNode){
		if(arrToLLNode.length == 0){
			System.out.println("Returning LLNode with value 0.");
			return ;
		}
		this.val = arrToLLNode[0];
		LLNode curr = this;
		for(int i=1; i < arrToLLNode.length; i++){
			curr.next = new LLNode(arrToLLNode[i]);
			curr = curr.next;
		}
	}

	// Setters for each member variable
	public void setNext(LLNode next){this.next = next;}
	
	public void setVal(int val){this.val = val;}

	// Getters for each member variable
	public LLNode getNext(){return this.next;}
	
	public int getVal(){return this.val;}

	/*** Two Pointer Example Begins here ***/

	/* GetMidPoint()
	 * Algorithm:
	 * 	  Using two pointers... :
	 *	 		LLNode once: hops on to the Next node (hops once) every loop
	 *			LLNode twice: hops to the NEXT NEXT (hops twice) every loop
	 *    will return what once lands on when twice 
	 *    reaches the limit of the linked list
	 * Retuns Mid Point LLNode with this as head
	 * (rounds down if given odd length Linked List)
	 */
	public LLNode getMidPoint(){
		// start from the head of linked list
		LLNode once = this; 
		LLNode twice = this;
		// stop looping before twice goes out of bounds
		while(twice.getNext() !=null && 
			twice.getNext().getNext()!=null){
			once = once.getNext();
			twice = twice.getNext().getNext();

			/* DEBUG ~ comment out to see how once + twice change */
			// System.out.println("--------------");
			// System.out.println("ONCE: " + once.getVal());
			// System.out.println("TWICE: " + twice.getVal());
		}
		// once is pointing to middle when exiting loop 
		return once;
	}

	public static void main(String[] args){
		// create test LinkedList
		LLNode test = new LLNode(new int[]{ 1, 2, 3, 4, 5,6, 7, 8, 9,10,
			11,12,13,14,15,16,17,18,19,20});
		// given the above LinkedList:
		// [1] -> [2] -> [3] -> ... -> [18] -> [19] -> [20]
		// return midpoint [10]!
		System.out.println(test.getMidPoint().getVal());
	}
}