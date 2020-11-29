# Linked List

A Linked list is a linear collection of data elements, often called nodes. Where the linear order 
given by mean of pointers. That is each node is divided into two parts: the data part and the link 
part. The data part contains the data within that node while the link part, also it is knwon as 
nextpointer field, that has the address of the next node assiciated to it.\

The Linked List is a dynamic data structure that is, it dynamically allocates the memory i-e allocates 
the memory addresses at run time. And so the main advantage of the linked list is that it saves the 
wastage of memory.\n

![LinkedList](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Linked%20List-Page-1.png)

### Operations on Linked List
-	Insertion
-	Searching
-	Sorting
-	Deletion

##### Insertion
Insertion can be performed at:

-	Start: Which is also called the head node. And to add a node at the start we have to put 
the new node at the start and so at the link part of the new node, we should put the start node's 
address.

![Insertion at Start](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Insertion%20At%20Start-Page-2.png)


-	Last: This is easy as the last one doesn't have any link so give the link of the newly 
added node to the one which was last.

![Insertion at End](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Insertion%20At%20End-Page-3.png)

 
-	Middle: This is a bit tricky as we have to deal with two nodes. So to add at the middle 
give the address of the node which is next to the new node. Then give the address of the new node 
to the one that is previous to the new node and so it should add the new node at the middel.

![Insertion at Middle](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Insertion%20At%20Middle-Page-4.png)


##### Searching
Searching is normal as we've to go through all the data fields of the nodes and search for an item 
which is required until the last node's data field.

##### Sorting
Sorting in link list is that you've to sort by either technique and so then you've to keep track of 
adding the node to some certain place or say swaping more specifically.

##### Deletion
Deleting a node from a linked list is also done at:
-	Start: To delete a node from the start you don't to worry as the start node has the address of 
the next node so delete the first (start) node the next (second) node should now be the start one.

![Deletion at Start](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Deletion%20At%20Start-Page-5.png)


-	End: The deletion at the end is easy as the last node don't have any address so delete it, and 
the previous node should now be the last one.

![Deletion at End](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Deletion%20%20At%20End-Page-6.png)


-	Middle: To delete a node at the middle, take the address of the node that is next to the node 
you're deleting, and give it to the node that is previous to the node you're deleting and so that 
node at the middle is gone.

![Deletion at Middle](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Deletion%20At%20Middle-Page-7.png)



### Types of Linked List
There are three three types of Linked List
-	Singly
-	Circular
-	Doubly

All the operations discussed above are in singly linked list. In doubly every node has the address 
of the next and previous node. While is circular that last node has the address of the start node or 
say the head node so that it makes a circle.

![Doubly Linked List](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Doubly%20Linked%20List-Page-8.png)

![Circular Linked List](https://github.com/taneemishere/Java-A-Z/blob/Taneem_Jan/Data%20Structures/LinkedList/Images/Circular%20Linked%20List-Page-9.png)


