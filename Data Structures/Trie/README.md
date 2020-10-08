# Trie Data Structure

## What is a Trie ?

- A Trie is a rooted tree that maintains a set of strings. Each string in the set is stored as a chain of characters that starts at the root. If two strings have a common prefix, they also have a common chain in the tree.

- A Trie can be visualized like a tree. It consists of nodes and edges. Each node consists of at max 26 children and edges connect each parent node to its children.

- Strings are stored in a top to bottom manner on the basis of their prefix in a trie. All prefixes of length 1 are stored at until level 1, all prefixes of length 2 are sorted at until level 2 and so on.

## Time complexity

- We can check in **O(n)** time whether a Trie contains a string of length **n**, because we can follow the chain that starts at the root node.

- We can also **add** a string of length **n** to the Trie in **O(n)** time by first following the chain and then adding new nodes to the Trie if necessary. 

## How it works 

A trie has 2 basic operations :

**Insert**

- It is used to insert a string into the Trie.

- A Trie consists of a special node called the root node. This node doesn't have any incoming edges. It only contains 26 outgoing edges for each letter in the alphabet and is the root of the Trie.

- So, the insertion of any string into a Trie starts from the root node. All prefixes of length one are direct children of the root node. In addition, all prefixes of length 2 become children of the nodes existing at level one.

- Time Complexity : O(Length of String)

- The following pseudo code will give a clearer idea :

```javascript
void insert(String s)

{

    current_node = root;
    
    for(every char in String s)
    
    {
    
        if(child node belonging to current char is not present (ie null))
	
        {
	
            child node = new Node();
	    
        }
	
        current_node = child_node;
	
    }
    
}
```

**Search or Lookup**

- Search or Lookup is used to find if a given string exists in the string or not.

- Generally returns a Boolean Value.

- It starts from the root and keeps travelling downwards until it either reaches the end of the string (ie String present in the Trie) or until the point where it reaches a node that doesn't have the required child (ie String not present in the Trie)

- Time Complexity : O(Length of String)

- The following pseudo code will give a clearer idea :

```javascript
boolean check(String s)
{
    for(every char in String s)
    {
        if(child node is null)    
        {
            return false;
        }
    }
    return true;
}
```



## Pictorial Representation
![Image](https://i.paste.pics/ABLGC.png?trs=4f6171b3351a08a2963bf2c4014e8cc2b0832a038161a39b0d676f60bb521a64)
