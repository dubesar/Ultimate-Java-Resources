import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Insert a word into the trie.
     *
     * @param word The word to insert.
     */
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            TrieNode node;
            char c = word.charAt(i);

            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                /**
                 * At this point, we know if we couldn't find word.charAt(i) in our trie,
                 * the word doesn't exist. Create a new TrieNode and populate it's child.
                 */
                node = new TrieNode();
                children.put(c, node);
            }

            children = node.children;
        }

        // Once we've reached the end of the word, mark the node as a leaf.
        node.endOfWord = true;
    }

    /**
     * Lookup a word in the trie.
     *
     * @param word The word to lookup.
     * @return True if the trie structure contains the word.
     */
    public boolean lookup(String word) {
        Map<Character, TrieNode> children = root.children;

        /**
         * For each letter in the word, traverse to the deepest child found.
         */
        for (int i = 0; i < word.length(); i++) {
            TrieNode node;
            char c = word.charAt(i);

            if (children.containsKey(c)) {
                node = children.get(c);
                children = node.children;
            } else {
                /* If at any point a character in the word isn't found, return false as the word doesn't exist. */
                return false;
            }
        }
        return true;
    }

    /**
     * Each node contains a hashmap of children nodes.
     */
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

}