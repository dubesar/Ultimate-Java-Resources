import java.util.TreeSet;

public class TreeSet_Example{


    public static void main(String args[]) {

        //The objects of the TreeSet class are stored in ascending order.

        TreeSet<String> values = new TreeSet<String>();
        values.add("Abhi");
        values.add("Babita");
        values.add("Chanchal");
        values.add("Dhruv");
        values.add("Ellen");

        System.out.println("Initial Set: " + values);  //Default storage in ascending order

        System.out.println("Reverse Set: " + values.descendingSet());   //Storing in descending order

        //Methods of Java TreeSet class

        System.out.println("Head Set: " + values.headSet("Chanchal", false));  // //

        System.out.println("SubSet: " + values.subSet("Abhi", false, "Ellen", true));

        System.out.println("TailSet: " + values.tailSet("Chanchal", true));

        //Retrieves and Removes the highest and lowest Value.

        System.out.println("Highest Value: "+values.pollFirst());

        System.out.println("Lowest Value: "+values.pollLast());

    }

}


//OUTPUT :

  /*

Initial Set: [Abhi, Babita, Chanchal, Dhruv, Ellen]
Reverse Set: [Ellen, Dhruv, Chanchal, Babita, Abhi]
Head Set: [Abhi, Babita]
SubSet: [Babita, Chanchal, Dhruv, Ellen]
TailSet: [Chanchal, Dhruv, Ellen]
Highest Value: Abhi
Lowest Value: Ellen

*/


