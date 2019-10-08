//LINEAR SEARCH

class LinearSearch { 
	// This function returns index of element x in arr[] 
	static int search(int arr[], int n, int x) 
	{ 
		for (int i = 0; i < n; i++) { 
			// Return the index of the element if the element 
			// is found 
			if (arr[i] == x) 
				return i; 
		} 

		// return -1 if the element is not found 
		return -1; 
	} 

	public static void main(String[] args) 
	{ 
		int[] arr = { 3, 4, 1, 7, 5 }; 
		int n = arr.length; 
		
		int x = 4; 

		int index = search(arr, n, x); 
		if (index == -1) 
			System.out.println("Element is not present in the array"); 
		else
			System.out.println("Element found at position " + index); 
	} 
} 


//BINARY SEARCH

class BinarySearch { 
    // Returns index of x if it is present in arr[l.. 
    // r], else return -1 
    int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
  

    public static void main(String args[]) 
    { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length; 
        int x = 10; 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } 
}
