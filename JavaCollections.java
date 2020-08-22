import java.util.*; 
  
public class CollectionsFramework { 
  
    // main method 
    public static void main(String[] args) { 
          
        // https://www.geeksforgeeks.org/how-to-learn-java-collections-a-complete-guide/
        // Instantiate an ArrayList Object 
        // Integer is a wrapper class for  
        // the basic datatype int 
        ArrayList<Integer> intArr = new ArrayList<Integer>(); 
          
        // Add elements using add() method 
        intArr.add(10); 
        intArr.add(12); 
        intArr.add(25); 
        intArr.add(19); 
        intArr.add(11); 
        intArr.add(3); 
          
        // Print the ArrayList on the console 
        System.out.println(intArr); 
          
        // Remove elements at index 1 and 4 
        intArr.remove(1); 
        intArr.remove(4); 
          
        // Print the ArrayList on the console 
        System.out.println(intArr); 
          
        // Check if intArr contains the element 25 
        if(intArr.contains(25)) 
        { 
            System.out.println("The ArrayList contains 25"); 
        } 
        else
        { 
            System.out.println("No such element exists"); 
        } 
          
        // Use get method to get the element at index 1 
        int elementAt1 = intArr.get(1); 
        System.out.println("The Element at index 1 now is " + elementAt1); 


        //-------------------------------------------------------------------------------

        Vector<Integer> intVector = new Vector<Integer>(); 
          
        // Print the initial size of the Vector 
        System.out.println("The initial size of the Vector = " + intVector.size()); 
        System.out.println(); 
          
        // Add elements using add method 
        intVector.add(11); 
        intVector.add(18); 
        intVector.add(1); 
        intVector.add(87); 
        intVector.add(19); 
        intVector.add(11); 
          
        // Print the Vector on the console 
        System.out.println("The Vector intVector : "); 
        System.out.println(intVector); 
        System.out.println("Size of intVector : " + intVector.size()); 
          
        System.out.println(); 
          
        // Remove the element at index 2 
        intVector.remove(2); 
          
        // Print the vector again on the console 
        System.out.println("The Vector intVector after removing element at 2 : "); 
        System.out.println(intVector); 
          
        System.out.println(); 
          
        // Clear all elements of the Vector and 
        // Print the Vector on the console 
        intVector.clear(); 
        System.out.println("The Vector intVector after using clear : "); 
        System.out.println(intVector); 


        //--------------------------------------------------------------------------------------

        Stack<String> strStack = new Stack<String>(); 
          
        // Add elements using the push() method 
        strStack.push("Stack"); 
        strStack.push("a"); 
        strStack.push("is"); 
        strStack.push("This"); 
          
        // The size() method gives the 
        // number of elements in the Stack 
        System.out.println("The size of the Stack is : " + strStack.size()); 
          
        // The search() method is 
        // used to search an element 
        // it returns the position of 
        // the element 
        int position = strStack.search("a"); 
        System.out.println("\nThe string 'a' is at position " + position); 
          
        System.out.println("\nThe elements of the stack are : "); 
        String temp; 
        int num = strStack.size(); 
          
        for(int i = 1; i <= num; i++) 
        { 
            // peek() returns the topmost element 
            temp = strStack.peek(); 
            System.out.print(temp + " "); 
              
            // pop() removes the topmost element 
            strStack.pop(); 
  
        } 

        //-------------------------------------------------------------------------------------

        LinkedList<String> strLinkedList = new LinkedList<String>(); 
          
        // Add elements to the LinkedList using add() 
        strLinkedList.add("This"); 
        strLinkedList.add("is"); 
        strLinkedList.add("a"); 
        strLinkedList.add("LinkedList"); 
          
        // The elements are retrieved using the get() method 
        System.out.println("The contents of strLinkedList : "); 
        for(int i = 0; i < strLinkedList.size(); i++) 
        { 
            System.out.print(strLinkedList.get(i) + " "); 
        } 
          
        // The elements are removed using remove() 
        strLinkedList.remove(0); 
        strLinkedList.remove(1); 
          
        System.out.println("\n\nThe contents of strLinkedList after remove operation : "); 
        for(int i = 0; i < strLinkedList.size(); i++) 
        { 
            System.out.print(strLinkedList.get(i) + " "); 
        } 

        //----------------------------------------------------------------------------------------

        PriorityQueue<Integer> intPriorityQueue = new PriorityQueue<Integer>(); 
          
        // Add elements using add() 
        intPriorityQueue.add(17); 
        intPriorityQueue.add(20); 
        intPriorityQueue.add(1); 
        intPriorityQueue.add(13); 
        intPriorityQueue.add(87); 
          
        // Print the contents of PriorityQueue 
        System.out.println("The contents of intPriorityQueue : "); 
        System.out.println(intPriorityQueue); 
          
        // The peek() method is used to retrieve  
          // the head of the PriorityQueue 
        System.out.println("\nThe head of the PriorityQueue : " + intPriorityQueue.peek()); 
          
        // The remove() method is used  
        // to remove a single instance 
        // of the specified object 
        intPriorityQueue.remove(17); 
          
        // Print the contents of PriorityQueue 
        System.out.println("\nThe contents of intPriorityQueue after removing 17 : "); 
        System.out.println(intPriorityQueue); 
          
        // The poll() method is used 
        // to retrieve and remove the 
        // element at the head of the PriorityQueue 
        Integer head = intPriorityQueue.poll(); 
        System.out.println("\nThe head of the PriorityQueue was : " + head); 
          
        // Print the contents of PriorityQueue 
        System.out.println("\nThe contents of intPriorityQueue after poll : "); 
        System.out.println(intPriorityQueue); 

        //---------------------------------------------------------------------------------------

        /*-----------HashSet-------------*/
          
        // Instantiate a HashSet object named strHashSet 
        HashSet<String> strHashSet = new HashSet<String>(); 
          
        // Add elements using add() 
        strHashSet.add("This"); 
        strHashSet.add("is"); 
        strHashSet.add("a"); 
        strHashSet.add("HashSet"); 
          
        // Create an Iterator to traverse through the HashSet 
        Iterator<String> hsIterator = strHashSet.iterator(); 
          
        // Print all the elements of the HashSet 
        System.out.println("Contents of HashSet : "); 
        while(hsIterator.hasNext()) 
        { 
            System.out.print(hsIterator.next() + " "); 
        } 
  
        /*---------LinkedHashSet----------*/
          
        // Instantiate an object of LinkedHashSet named strLinkedHashSet 
        // Pass the name of the HashSet created earlier to copy all of the contents 
        // of the HashSet to the LinkedHashSet using a constructor 
        LinkedHashSet<String> strLinkedHashSet = new LinkedHashSet<String>(strHashSet); 
          
        // Create an Iterator to traverse through the LinkedHashSet 
        Iterator<String> lhsIterator = strLinkedHashSet.iterator(); 
          
        // Print all the elements of the LinkedHashSet 
        System.out.println("\n\nContents of LinkedHashSet : "); 
        while(lhsIterator.hasNext()) 
        { 
            System.out.print(lhsIterator.next() + " "); 
        } 

        //--------------------------------------------------------------------------------------

        TreeSet<Integer> intTreeSet = new TreeSet<Integer>(); 
          
        // Add elements using add() 
        intTreeSet.add(18); 
        intTreeSet.add(13); 
        intTreeSet.add(29); 
        intTreeSet.add(56); 
        intTreeSet.add(73); 
          
        // Try to add a duplicate 
        // Observe output as it will not be added 
        intTreeSet.add(18); 
          
        // Print the TreeSet on the console 
        System.out.println("The contents of intTreeSet : "); 
        System.out.println(intTreeSet); 
          
        // Remove 18 using remove() 
        if(intTreeSet.remove(18)) 
        { 
            System.out.println("\nElement 18 has been removed"); 
        } 
        else
        { 
            System.out.println("\nNo such element exists"); 
        } 
  
        // Try to remove a non-existent element 
        if(intTreeSet.remove(12)) 
        { 
            System.out.println("\nElement 18 has been removed"); 
        } 
        else
        { 
            System.out.println("\nNo such element exists"); 
        } 
          
        System.out.println(); 
          
        // Print the TreeSet on the console 
        System.out.println("The contents of intTreeSet : "); 
        System.out.println(intTreeSet); 

        //----------------------------------------------------------------------------------
        /*--------------HashMap---------------*/
          
        // Instantiate an object of HashMap named hashMap 
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>(); 
          
        // Add elements using put() 
        hashMap.put(1, "This"); 
        hashMap.put(2, "is"); 
        hashMap.put(3, "HashMap"); 
          
        // Print the HashMap contents on the console 
        System.out.println("Contents of hashMap : "); 
        System.out.print(hashMap.entrySet()); 
          
        // Add a duplicate key 
        hashMap.put(3, "Duplicate"); 
          
        // Add a duplicate value 
        hashMap.put(4, "This"); 
          
        // Print the HashMap contents on the console 
        System.out.println("\nContents of hashMap after adding duplicate : "); 
        System.out.print(hashMap.entrySet()); 
          
        /*--------------Hashtable----------------*/
          
        // Instantiate an object of Hashtable named hashTable 
        Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>(); 
          
        // Add elements using put() 
        hashTable.put(11, "This"); 
        hashTable.put(12, "is"); 
        hashTable.put(13, "Hashtable"); 
          
        // Print the Hashtable contents on the console 
        System.out.println("\n\nContents of hashTable : "); 
        System.out.print(hashTable.entrySet()); 
  
        // Add a duplicate key 
        hashTable.put(11, "Duplicate"); 
          
        // Add a duplicate value 
        hashTable.put(14, "is"); 
          
        // Print the Hashtable contents on the console 
        System.out.println("\nContents of hashTable after adding duplicate : "); 
        System.out.print(hashTable.entrySet()); 
          
        /*---------------LinkedHashMap---------------*/
          
        // Instantiate an object of LinkedHashMap named linkedHashMape 
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(); 
          
        // Add elements using put() 
        linkedHashMap.put(21, "This"); 
        linkedHashMap.put(22, "is"); 
        linkedHashMap.put(23, "LinkedHashMap"); 
          
        // Print the LinkedHashMap contents on the console 
        System.out.println("\n\nContents of linkedHashMap : "); 
        System.out.print(linkedHashMap.entrySet()); 
          
        // Add a duplicate key 
        linkedHashMap.put(22, "Duplicate"); 
          
        // Add a duplicate value 
        linkedHashMap.put(24, "This"); 
          
        // Print the LinkedHashMap contents on the console 
        System.out.println("\nContents of linkedHashMap after adding duplicate : "); 
        System.out.print(linkedHashMap.entrySet()); 

        //--------------------------------------------------------------------------------

        // Instantiate an object of TreeMap named treeMap 
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(); 
          
        // Add elements using put() 
        treeMap.put(1, "This"); 
        treeMap.put(2, "is"); 
        treeMap.put(3, "TreeMap"); 
          
        // Print the contents of treeMap on the console 
        System.out.println("The contents of treeMap : "); 
        System.out.println(treeMap); 
          
        // Add a duplicate key 
        treeMap.put(1, "Duplicate"); 
          
        // Add a duplicate value 
        treeMap.put(4, "is"); 
          
        // Print the contents of treeMap on the console 
        System.out.println("\nThe contents of treeMap after adding duplicates : "); 
        System.out.println(treeMap);
          
    } 
  
} 
