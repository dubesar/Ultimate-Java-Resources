/*Binary Tree (Array implementation)

Talking about representation, trees can be represented in two ways: 
1) Dynamic Node Representation (Linked Representation). 
2) Array Representation (Sequential Representation).

---------------------------------------------------
 Array Representation (Sequential Representation)
---------------------------------------------------

To represent tree using an array, the numbering of nodes can start either from 0–(n-1) or 1– n. 

       A(0)    
     /   \
    B(1)  C(2)  
  /   \      \
 D(3)  E(4)   F(6) 
OR,
      A(1)    
     /   \
    B(2)  C(3)  
  /   \      \
 D(4)  E(5)   F(7)  


// JAVA implementation of tree using array
// numbering starting from 0 to n-1.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Tree {
	public static void main(String[] args)
	{
		Array_imp obj = new Array_imp();
		obj.Root("A");
		obj.set_Right("C", 0);
		obj.set_Left("D", 1);
		obj.set_Right("E", 1);
		obj.set_Left("F", 2);
		obj.print_Tree();
	}
}

class Array_imp {
	static int root = 0;
	static String[] str = new String[10];

	public void Root(String key)
	{
		str[0] = key;
	}

	public void set_Left(String key, int root)
	{
		int t = (root * 2) + 1;

		if (str[root] == null) {
			System.out.printf("Can't set child at %d, no parent found\n", t);
		}
		else {
			str[t] = key;
		}
	}

	public void set_Right(String key, int root)
	{
		int t = (root * 2) + 2;

		if (str[root] == null) {
			System.out.printf("Can't set child at %d, no parent found\n", t);
		}
		else {
			str[t] = key;
		}
	}

	public void print_Tree()
	{
		for (int i = 0; i < 10; i++) {
			if (str[i] != null)
				System.out.print(str[i]);
			else
				System.out.print("-");
		}
	}
}
