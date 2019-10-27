import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ArrayListIteration {

    public static void main(String[] args) {
        // Creating an ArrayList of String
        List<String> animals = Arrays.asList("Lion", "Tiger", "Cat", "Dog");

        System.out.println(animals);

        // Iteration Using For Loop
        for (int i = 0; i < animals.size(); i++) {
             System.out.println(animals.get(i));
        }
	
	    // Iteration Using Enhanced For Loop
        for (String animal : animals) {
            System.out.println(animal); 
        }
	    
		// Iteration Using For Each Loop
		animals.forEach(System.out::println);
		
		// Iteration Using Iterator. 
	    Iterator<String> animalsIterator = animals.iterator();
 
        while(animalsIterator.hasNext()) {
              System.out.println(animalsIterator.next()); 
        }
		
        //List Iterator 
		
		ListIterator<String> listIterator = animals.listIterator();
 
        while(listIterator.hasNext()) {
             System.out.println(listIterator.next());
        }

    }
}
