import java.util.*;

class Node{
	int data;
	Node left;
	Node right;

	public Node(int d){
		data = d;
		left = null;
		right = null;
	}

}

class BST{

	Node head;

	public BST(int d){
		head = new Node(d);
	}

	public void addNode(Node h,Node n){
		if(n.data < h.data){
			if(h.left == null){
				h.left = n;
				return;
			}
			else
				addNode(h.left,n);
		}
		else{
				if(h.right == null){
					h.right = n;
					return;
				}
				else
					addNode(h.right,n);
		}
	}

	public void search(int d){
		boolean found = false;
		Node ptr = head; //Creating a pointer node, which will help us to find the element, initializing it from the head(searching drom the head)
		while(ptr!=null){
			if(ptr.data == d){
				System.out.println("Yes, the element is present in the tree!");
				found = true;
				break;
			}
			else if(d > ptr.data)
				ptr = ptr.right;
			else
				ptr = ptr.left;
		}
		if(!found)
			System.out.println("Element not present!");
	}

	public void inorder(Node n) { //InOrder Tree Traversal
		if(n!=null)
		{
			inorder(n.left);
			System.out.print(n.data+"\t");
			inorder(n.right);
		}
	}
	public void preorder(Node n) { //PreOrder Tree Traversal
		
		if(n!=null)
		{
			System.out.print(n.data+"\t");
			preorder(n.left);
			preorder(n.right);
		}
	}
	public void postorder(Node n) { //PostOrder Tree Traversal
		
		if(n!=null)
		{
			postorder(n.left);
			postorder(n.right);
			System.out.print(n.data+"\t");
		}
	}
	
}

public class BinarySearchTreeExample{
	public static void main(String[] args){
		int[] arr = {5,2,7,4,1,9}; //Example array
		BST bst = new BST(arr[0]); //Setting the first element as the head of the binary search tree
		for(int i=1;i<6;i++){
			Node nodeToBeAdded = new Node(arr[i]);
			bst.addNode(bst.head , nodeToBeAdded); // The elements of the array are added one by one
		}

		
		bst.search(4); //Let's search the Node with the value 4 in the bst we have created
		bst.search(3);//Searching 3
		bst.search(9);//Searching 9
		bst.search(6);//Searching 6
		
		System.out.println("\nInOrder Traversal");
		bst.inorder(bst.head); //InOrder Traversal (Left-Root-Right)
		
		System.out.println("\nPreOrder Traversal");
		bst.preorder(bst.head);//PreOrder Traversal (Root-Left-Right)
		
		System.out.println("\nPostOrder Traversal");
		bst.postorder(bst.head);//PostOrder Traversal (Left-Right-Root)

		/*Output: 
		Yes, the element is present in the tree!
		Element not present!
		Yes, the element is present in the tree!
		Element not present!
		InOrder Traversal
		1	2	4	5	7	9	
		PreOrder Traversal
		5	2	1	4	7	9	
		PostOrder Traversal
		1	4	2	9	7	5	
		*/

	}
}