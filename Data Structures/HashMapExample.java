
// Import the HashMap class
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap object called map
        HashMap<String, String> map = new HashMap<String, String>();

        // Add keys and values (Country, City)
        map.put("England", "London");
        map.put("Germany", "Berlin");
        map.put("Norway", "Oslo");
        map.put("USA", "Washington DC");

        // Prints key value pairs
        System.out.println(map);

        // To access value
        map.get("England");

        // To remove an item
        map.remove("England");

        // To find out the number of items
        map.size();

        // Looping through the items in HashMap
        // and printing the keys
        for (String i : map.keySet()) {
            System.out.println(i);
        }

        // Looping through the items in HashMap
        // and printing the values
        for (String i : map.values()) {
            System.out.println(i);
        }

        // To remove all items
        map.clear();
    }
}
