
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class ArrayLists {
	public static final Integer[] i = new Integer[] { 10, 20, 30 }; 			// [0,20,30]
	public static final Integer[] j = new Integer[] { 60, 70 }; 				// [60,70]
	public static final Integer[] k = new Integer[] { 80, 90 };					// [80,90]

	public static void main(String[] args) {

//		Create/Initialize List (default)
		List<Integer> ls_default = new ArrayList<Integer>(); 					// []
//		Create/Initialize List with initial capacity 10	
		List<Integer> ls_initial_size = new ArrayList<Integer>(10); 			// [ , , , , , , , , , ]
//		Create/Initialize List with existing Collection			
		List<Integer> ls_collection = new ArrayList<>(Arrays.asList(i)); 		// [0,20,30]

//-----Add Values-------------//
		ls_collection.add(50); 													// [0,20,30,50]
		ls_collection.add(3, 40); 												// [0,20,30,40,50]
		ls_collection.addAll(Arrays.asList(k)); 								// [0,20,30,40,50,80,90]
		ls_collection.addAll(5, Arrays.asList(j)); 								// [0,20,30,40,50,60,70,80,90]

//-----Size--------//
		ls_collection.size(); 													// 9
		ls_collection.isEmpty(); 												// false

//-----Find elements----//
		ls_collection.indexOf(30); 												// 2
		ls_collection.lastIndexOf(50); 											// 4
		ls_collection.contains(90); 											// true
		ls_collection.containsAll(Arrays.asList(i)); 							// true

//-----Get and set elements-----//
		ls_collection.get(4); 													// 30
		ls_collection.set(0, 10); 												// [10,20,30,40,50,60,70,80,90]
		ls_collection.subList(0, 3);											// [10, 20, 30]

//-----Loop over each List item----//
		System.out.println(ls_collection.toString()); 							// [10, 20, 30, 40, 50, 60, 70, 80, 90]

		ls_collection.forEach((val) -> System.out.print(val + " ")); 			// 10 20 30 40 50 60 70 80 90
		System.out.println();

		for (Integer val : ls_collection) {
			System.out.print(val + " ");
		} 																		// 10 20 30 40 50 60 70 80 90
		System.out.println();

		ListIterator<Integer> it = ls_collection.listIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		} 																		// 10 20 30 40 50 60 70 80 90
		System.out.println();

//-----Remove elements----//
		ls_collection.remove(0); 												// [20,30,40,50,60,70,80,90]
		ls_collection.remove(ls_collection.size() - 1); 						// [20,30,40,50,60,70,80]
		ls_collection.remove(ls_collection.indexOf(20)); 						// [30,40,50,60,70,80]
		ls_collection.removeAll(Arrays.asList(j)); 								// [30,40,50,80]
		ls_collection.clear(); 													// []

//----Sort---//
		ls_default.add(60);
		ls_default.add(20);
		ls_default.add(80);
		ls_default.add(10);
		Collections.sort(ls_default);											// [10, 20, 60, 80]
		Collections.sort(ls_default, Collections.reverseOrder());				// [80, 60, 20, 10]
		Collections.sort(ls_default, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		});																		// [10, 20, 60, 80]
	}
}
