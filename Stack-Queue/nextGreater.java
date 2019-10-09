class nextGreat
{ 
	static void printNGE(int arr[], int n) 
	{ 
		int next, i, j; 
		for (i=0; i<n; i++) 
		{ 
			next = -1; 
			for (j = i+1; j<n; j++) 
			{ 
				if (arr[i] < arr[j]) 
				{ 
					next = arr[j]; 
					break; 
				} 
			} 
			System.out.println(arr[i]+" -- "+next); 
		} 
	} 
	
	public static void main(String args[]) 
	{ 
		int arr[]= {11, 13, 21, 3}; 
		int n = arr.length; 
		printNGE(arr, n); 
	} 
} 
