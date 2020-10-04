
// Import the HashMap class
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashSet object called set
        HashSet<String> set = new HashSet<>();

        // Add items to set
        set.add("London");
        set.add("Brest");
        set.add("Berlin");

        // Print items
        System.out.println(set);

        // Attempt to add London twice
        set.add("London");

        // Print values, London is not duplicated
        System.out.println(set);

        // To Remove An Item
        set.remove("London");

        // To find out the number of items
        System.out.println(set.size());

        // Looping through the items
        for (String i : set) {
            System.out.println(i);
        }

        // Is set empty or not
        System.out.println(set.isEmpty());

        // Verify if an element is present
        System.out.println(set.contains("Paris"));

        // To remove all items
        set.clear();
    }
}
