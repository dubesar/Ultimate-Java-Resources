# Trie Data Structure

## What is a Trie ?

- A Trie is a rooted tree that maintains a set of strings. Each string in the set is stored as a chain of characters that starts at the root. If two strings have acommon prefix, they also have a common chain in the tree.

- We can check in **O(n)** time whether a Trie contains a string of length **n**, because we can follow the chain that starts at the root node. We can also add a string of length **n** to the Trie in **O(n)** time by first following the chain and then adding new nodes to the Trie if necessary. Using a Trie, we can find the longest prefix of a given string such that the prefix belongs to the set. Moreover, by storing additional information in each node, we can calculate the number of strings that belong to the set and have agiven string as a prefix.

## Pictorial Representation
![Image](https://i.paste.pics/ABLGC.png?trs=4f6171b3351a08a2963bf2c4014e8cc2b0832a038161a39b0d676f60bb521a64)