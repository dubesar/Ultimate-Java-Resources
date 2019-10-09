// This is a java program to display the use of the java.util.TreeSet class

import java.util.TreeSet;

public class TreeSetExample {
        public static void main(String[] args) {
                System.out.println("TreeSet is like HashSet but it sorts the elements in ascending order.");

                TreeSet<String> treeSet = new TreeSet<String>();                // Instance using Default Constructor
                treeSet.add("Simple");                                          // adding elements using the .add() method
                treeSet.add("TreeSet");
                treeSet.add("TreeSet");

                System.out.println(treeSet);                                    // output will be a set of strings in the instance.

                // TreeSet is implemented from the SortedSet interface and will omit duplicates

                TreeSet<Integer> duplicateEntryTreeSet = new TreeSet<Integer>();
                duplicateEntryTreeSet.add(300);
                duplicateEntryTreeSet.add(102);
                duplicateEntryTreeSet.add(102);                                 // Duplicate value will not be stored

                System.out.println(duplicateEntryTreeSet);                      // Output will be [102, 300]

                // Objects stored in TreeSet should be homogeneous
                // and comparable otherwise the program will throw an exception

                TreeSet<StringBuilder> builderSet = new TreeSet<StringBuilder>();
                builderSet.add(new StringBuilder("T"));                         // Will result in java.lang.ClassCastException
                builderSet.add(new StringBuilder("M"));
                builderSet.add(new StringBuilder("I"));

        }
}
