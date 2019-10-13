public class coinChange {
	
	public static int count( int S[], int m, int n ) 
	{ 
	    // table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
	    int dp[]=new int[n+1]; 
	  
	    // Base case (If given value is 0) 
	    dp[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the 
	    // picked coin 
	    for(int i=0; i<m; i++) 
	        for(int j=S[i]; j<=n; j++) 
	            dp[j] += dp[j-S[i]]; 
	  
	    return dp[n]; 
	} 
	
	public static void main(String[] args) {
		int arr[] = {4, 12, 31, 52}; 
        int m = arr.length; 
        int n = 4; 
        System.out.println(count(arr, m, n)); 
	}
}

