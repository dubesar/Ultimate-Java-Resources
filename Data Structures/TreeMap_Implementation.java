import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

class TreeMap_Implementation {


    //A TreeMap is a map implementation where they are always sorted based on the natural ordering of the keys,
    // or based on a custom Comparator that you can provide at the time of creation of the TreeMap.

    //
        public static void main(String[] args) {
            // Creating a TreeMap
            SortedMap<String, String> names  = new TreeMap<>();


            // Adding new key-value pairs to a TreeMap
            names.put("Aanchal", "girl");
            names.put("Rahul", "boy");
            names.put("Arjun", "boy");
            names.put("Karen", "girl");
            names.put("Salman", "boy");

            // Printing the TreeMap (Output will be sorted based on keys)
            System.out.println(names);

            System.out.println(((TreeMap<String, String>) names).firstEntry());

            System.out.print(((TreeMap<String, String>) names).lastEntry());


            SortedMap<String, String> names_2 = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s2.compareTo(s1);
                }
            });

            // Adding new key-value pairs to a TreeMap
            names_2.put("Aanchal", "girl");
            names_2.put("Rahul", "boy");
            names_2.put("Arjun", "boy");
            names_2.put("Karen", "girl");
            names_2.put("Salman", "boy");

            // Printing the TreeMap (The keys will be sorted based on the supplied comparator in descending order.)
            System.out.println(names_2);

            System.out.println(((TreeMap<String, String>) names_2).firstEntry());

            System.out.print(((TreeMap<String, String>) names_2).lastEntry());
        }

    }




//Output
//{Aanchal=girl, Arjun=boy, Karen=girl, Rahul=boy, Salman=boy}
//Aanchal=girl
//Salman=boy{Salman=boy, Rahul=boy, Karen=girl, Arjun=boy, Aanchal=girl}
//Salman=boy
//Aanchal=girl
