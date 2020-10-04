import java.util.*; 
public class Main { 
    public static void main(String[] args) { 
        //Declare Deque object 
        Deque<String> deque = new LinkedList<String>(); 
        // add elements to the queue using various methods 
        deque.add("One");           //add ()
        deque.addFirst("Two");      //addFirst ()
        deque.addLast("Three");     //addLast ()
        deque.push("Four");         //push ()
        deque.offer("Five");        //offer ()
        deque.offerFirst("Six");    //offerFirst ()
        deque.offerLast("Seven");   //offerLast ()
        System.out.println("Initial Deque:");
        System.out.print(deque + " "); 
      
       // Iterate using standard iterator
        System.out.println("\n\nDeque contents using Standard Iterator:"); 
        Iterator iterator = deque.iterator(); 
        while (iterator.hasNext()) 
            System.out.print(" " + iterator.next()); 
        
       // Iterate using Reverse order iterator 
        Iterator reverse = deque.descendingIterator(); 
        System.out.println("\n\nDeque contents using Reverse Iterator:"); 
        while (reverse.hasNext()) 
            System.out.print(" " + reverse.next()); 
          
        // Peek () method
        System.out.println("\n\nDeque Peek:" + deque.peek()); 
        System.out.println("\nDeque,After peek:" + deque); 
        
         // Pop () method 
        System.out.println("\nDeque Pop:" + deque.pop()); 
        System.out.println("\nDeque,After pop:" + deque); 
   
        // contains () method
        System.out.println("\nDeque Contains Three: " +  deque.contains("Three")); 
   
        deque.removeFirst();        //removeFirst () 
        deque.removeLast();         //removeLast ()
        System.out.println("\nDeque, after removing "  + "first and last elements: " + deque); 
   } 
}