/* A Dynamic Programming based Java program to find minimum number operations to convert String1  to String2 */ 
class EditDistance 
{ 
	static int min(int x,int y,int z) 
	{ 
		if (x <= y && x <= z) 
			return x; 
		if (y <= x && y <= z) 
			return y; 
		else 
			return z; 
	} 

	static int editDistDP(String str1, String str2, int m, int n) 
	{ 
		// Create a table to store results of subproblems 
		int dp[][] = new int[m+1][n+1]; 
	
		// Fill d[][] in bottom up manner 
		for (int i=0; i<=m; i++) 
		{ 
			for (int j=0; j<=n; j++) 
			{ 
				// If first string is empty, only option is to 
				// insert all characters of second string 
				if (i==0) 
					dp[i][j] = j; // Min. operations = j 
	
				// If second string is empty, only option is to 
				// remove all characters of second string 
				else if (j==0) 
					dp[i][j] = i; // Min. operations = i 
	
				// If last characters are same, ignore last char 
				// and recur for remaining string 
				else if (str1.charAt(i-1) == str2.charAt(j-1)) 
					dp[i][j] = dp[i-1][j-1]; 
	
				// If the last character is different, consider all 
				// possibilities and find the minimum 
				else
					dp[i][j] = 1 + min(dp[i][j-1], // Insert 
							   dp[i-1][j], // Remove 
							   dp[i-1][j-1]); // Replace 
			} 
		} 

		return dp[m][n]; 
	} 

	public static void main(String args[]) 
	{ 
		String str1 = "Rohan"; //1st String that need to be converted to 2nd String
		String str2 = "Roushan"; //2nd String
		System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) ); 
	} 
}

