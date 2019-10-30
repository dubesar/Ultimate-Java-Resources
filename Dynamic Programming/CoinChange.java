/**
 * This algorithm solves this problem:
 * + Given a value N, if we want to make change for N cents, and we have infinite supply
 * of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 * <p>
 * Note: every coin can only be used once and this solution assumes coin values are whole
 * integers.
 */
public class CoinChange {

	private int byRecursionApproach(int S[], int m, int n) {
		// If n is 0 then there is 1 solution (do not include any coin) 
		if (n == 0) 
			return 1;
		  
		// If n is less than 0 then no solution exists 
		if (n < 0) 
			return 0; 
	  
		// If there are no coins and n is greater than 0, then no solution exist 
		if (m <=0 && n >= 1) 
			return 0; 
	  
		// The count is the sum of solutions: (i) including S[m-1] (ii) excluding S[m-1] 
		return byRecursionApproach(S, m - 1, n) + 
				byRecursionApproach(S, m, n - S[m-1]); 
	}

	private int byDynamicApproach(int S[], int m, int n) {
		// table[i] will be storing the number of solutions for 
		// value i. We need n+1 rows as the table is constructed 
		// in bottom up manner using the base case (n = 0) 
		int table[] = new int[n+1]; 
	  
		// Base case (If given value is 0) 
		table[0] = 1; 
	  
		// Pick all coins one by one and update the table[] values 
		// after the index greater than or equal to the value of the 
		// picked coin 
		for(int i = 0; i < m; i++) 
			for(int j = S[i]; j <= n; j++) 
				table[j] += table[j - S[i]]; 
	  
		return table[n]; 
	} 

	public static void main(String[] args) {
		//array of different coins we can use
		int[] arr = {2, 4, 6, 10, 8};
		//this is the target amount
		int target = 12;

		CoinChange coinChange = new CoinChange();
		System.out.println("Number of different ways by recursion: " +
				coinChange.byRecursionApproach(arr, arr.length, target));
		System.out.println("Number of different ways by dynamic approach: " +
				coinChange.byDynamicApproach(arr, arr.length, target));
	}
}
