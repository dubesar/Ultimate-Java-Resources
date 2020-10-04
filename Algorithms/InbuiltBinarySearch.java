// Arrays.binarysearch()  : Works for arrays which can be of primitive data type also


// Java program to demonstrate working of Arrays. 
// binarySearch() in a sorted array. 
import java.util.Arrays; 
  
public class BinarySearch { 
    public static void main(String[] args) 
    { 
        int arr[] = { 10, 20, 15, 22, 35 }; 
        Arrays.sort(arr); 
  
        int key = 22; 
        int res = Arrays.binarySearch(arr, key); 
        if (res >= 0) 
            System.out.println(key + " found at index = " 
                                                  + res); 
        else
            System.out.println(key + " Not found"); 
  
        key = 40; 
        res = Arrays.binarySearch(arr, key); 
        if (res >= 0) 
            System.out.println(key + " found at index = " 
                                                  + res); 
        else
            System.out.println(key + " Not found"); 
    } 
} 

// Collections.binarysearch() : Works for objects Collections like ArrayList and LinkedList.

// Java program to demonstrate working of Collections. 
// binarySearch() 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections; 
   
public class BinarySearch 
{ 
    public static void main(String[] args) 
    { 
        List<Integer> al = new ArrayList<Integer>(); 
        al.add(1); 
        al.add(2); 
        al.add(3); 
        al.add(10); 
        al.add(20); 
   
        // 10 is present at index 3. 
        int key = 10; 
        int res = Collections.binarySearch(al, key); 
        if (res >= 0) 
            System.out.println(key + " found at index = " 
                                                 + res); 
        else
            System.out.println(key + " Not found"); 
  
        key = 15; 
        res = Collections.binarySearch(al, key); 
        if (res >= 0) 
            System.out.println(key + " found at index = "
                                                  + res); 
        else
            System.out.println(key + " Not found"); 
    } 
} 



