
import java.util.*;  
 class ArrayListsolution{  
 public static void main(String args[]){  
ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
      list.add("Ravi");//Adding object in arraylist    
      list.add("Vijay");    
      list.add("Ravi");    
      list.add("Ajay");    
      //Invoking arraylist object   
      System.out.println(list);  
  }  
 }  
}  
/*
FUNCTION RELATED TO ARRAYLIST
1.void add(int index, E element):It is used to insert the specified element at the specified position in a list.
2.boolean add(E e):It is used to append the specified element at the end of a list.
3.boolean addAll(Collection<? extends E> c):It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
4.boolean addAll(int index, Collection<? extends E> c):It is used to append all the elements in the specified collection, starting at the specified position of the list.
5.void clear():It is used to remove all of the elements from this list.
6.void ensureCapacity(int requiredCapacity):It is used to enhance the capacity of an ArrayList instance.
7. get(int index):It is used to fetch the element from the particular position of the list.
8.boolean isEmpty():It returns true if the list is empty, otherwise false.
9.int lastIndexOf(Object o):It is used to return the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.
10.Object[] toArray():It is used to return an array containing all of the elements in this list in the correct order.
11.<T> T[] toArray(T[] :It is used to return an array containing all of the elements in this list in the correct order.
12.boolean contains(Object o):It returns true if the list contains the specified element
13.int indexOf(Object o):It is used to return the index in this list of the first occurrence of the specified element, or -1 if the List does not contain this element.
14. remove(int index):It is used to remove the element present at the specified position in the list.
15.boolean removeAll(Collection<?> c):It is used to remove all the elements from the list.
16,boolean removeIf(Predicate<? super E> filter):It is used to remove all the elements from the list that satisfies the given predicate.
17.void replaceAll(UnaryOperator<E> operator):It is used to replace all the elements from the list with the specified element.
18.void retainAll(Collection<?> c):It is used to retain all the elements in the list that are present in the specified collection.
19.void sort(Comparator<? super E> c):It is used to sort the elements of the list on the basis of specified comparator.
20.int size():It is used to return the number of elements present in the list.
21.<T> [] sublist(int start, int end) : Use to get the sublist of the list 
*/
