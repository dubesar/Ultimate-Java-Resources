import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CreateArrayListExample {

    public static void main(String[] args) {
        // Creating an ArrayList of String
        List<String> animals = new ArrayList<>();

        // Adding new elements to the ArrayList
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Cat");
        animals.add("Dog");

        System.out.println(animals);

        // Adding an element at a particular index in an ArrayList
        animals.add(2, "Elephant");
        System.out.println(animals);
	
	// Removing an element at a particular index 3 in an ArrayList
	animals.remove(3);
	System.out.println(animals);
	// There's also removeAll() and removeIf() method which can be used as convenient

	// A particualr element can be accessed using get() function and a particulare index can be assigned value using set() method
	animals.set(1,"Rhino");
	System.out.println(animals.get(1));

	//sorting the list
	Collections.sort(animals);
	System.out.println(animals);
	 
	//Reverse the Arraylist    
	Collections.reverse(animals);
	System.out.println(animals);

    }
}
