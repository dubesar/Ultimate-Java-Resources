class TERNARY { 

	// Function to perform Ternary Search 
	static int ternarySearch(int l, int r, int key, int array[]){ 
		while (l<=r){ 

			// Find the mid1 and mid2 
			int mid1 = l + (r - l) / 3; 
			int mid2 = r - (r - l) / 3; 

			// Check if key is present at any mid 
			if (array[mid1] == key) { 
				return mid1; 
			} 
			if (array[mid2] == key) { 
				return mid2; 
			} 

			/* Since key is not present at mid, 
			 check in which side it is present 
			 and repeat the Search operation 
			 in that region */

			if (key < array[mid1]) { 

				// The key lies in between l and mid1 
				r = mid1 - 1; 
			} 
			else if (key > array[mid2]) { 

				// The key lies in between mid2 and r 
				l = mid2 + 1; 
			} 
			else { 

				// The key lies in between mid1 and mid2 
				l = mid1 + 1; 
				r = mid2 - 1; 
			} 
		} 

		// Key not found 
		return -1; 
	} 
}
