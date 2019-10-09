// java program to show the use of java.util.HashSet

import java.util.HashSet;

public class HashSetExample {
        public static void main(String[] args) {
                // HashSet implements the Set interface backed by a HashMap instance

                // Syntax: HashSet<Object> obj = new HashSet<Object>();

                HashSet<Integer> intSet = new HashSet<Integer>();
                intSet.add(10);
                intSet.add(1);
                intSet.add(500);
                intSet.add(5);

                // output will be unordered set of element present in the hashSet instance
                System.out.println("HashSet:\n" + intSet);

                // HashSet dose not allow duplicates to be inserted.
                HashSet<String> hashSet = new HashSet<String>();
                hashSet.add("HashSet");
                hashSet.add("example");
                hashSet.add("java");
                hashSet.add("java");

                System.out.println("HashSet (all elements, without duplicates):\n" + hashSet);

                // HashSet class offers constant time performance for basic operations like add, remove, contains and size
                System.out.println("intSet size: " + intSet.size());

                // Some extra functions
                System.out.println("intSet contains element 1? : " + intSet.contains(1));  // returns boolean and searches the set
                System.out.println("Clearing hashSet");
                hashSet.clear();                                                            // returns void and removes all elements
                System.out.println("Check if hashSet is empty: " + hashSet.isEmpty());     // returns boolean and checks if empty
        }
}
