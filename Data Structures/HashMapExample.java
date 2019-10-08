import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * @author mariojp
 */
public class HashMapExample {

    public static void main(String[] args) {
        // Creating an HashMap of String key and String value
        // key is animal name and value Scientific Names
        Map<String,String> animals = new HashMap();

        // Adding new elements to the ArrayList
        animals.put("Lion","Panthera leo");
        animals.put("Tiger","Panthera Tigris");
        animals.put("Cat","Felis domesticus");
        animals.put("Dog","Canis lupus familiaris");
        animals.replace("Rhino","Rhinoceros");
        System.out.println(animals);

    	// Removing an element at a particular key 'Lion' in a HashMap
        animals.remove("Lion");
	    System.out.println(animals);
	    // There's also clear() method which can be used as convenient
    
	    // A particualr element can be replace using replace(key,value) function and a particulare key can be assigned value using set() method
        animals.replace("Rhino","Rhinoceros unicornis");
        System.out.println(animals.get("Rhino"));

        //Map iterable by Set of keys
        System.out.println(animals.keySet());
        //Map iterable by List of values
        System.out.println(animals.values());

        //Map iterable by EntrySet<key,value>
        for (Entry var : animals.entrySet()) {
            System.out.println("name: "+var.getKey()+" value: "+var.getValue());
        }
        

	    //sorting the list
	    //Collections.sort(animals);
	    //System.out.println(animals);

    }
}
