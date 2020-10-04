
class LIS 
{ 
	static int liss(int a[],int n) 
	{ 
		int lis[n]; 
		int i,j,max = 0; 

		for ( i = 0; i < n; i++ ) 
			lis[i] = 1; 

		for ( i = 1; i < n; i++ ) 
			for ( j = 0; j < i; j++ ) 
						if ( a[i] > a[j] && lis[i] < lis[j] + 1) 
					lis[i] = lis[j] + 1; 

		for ( i = 0; i < n; i++ ) 
			if ( max < lis[i] ) 
				max = lis[i]; 

			return max; 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = { 0,10,20,59,4,1,26,8}; 
			int n = arr.length; 
			System.out.println("Length of lis is " + liss( arr, n ) + "\n" ); 
	} 
} 
