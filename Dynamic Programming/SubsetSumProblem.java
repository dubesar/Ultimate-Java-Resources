package com.jagjit.Hactoberfest;

public class SubsetSumProblem {

	private static boolean subsetSum(int[] arr, int sum) {

		int len = arr.length;

		// dp[i][j] stores true if subset with sum j can be obtained
		// i represent the first i items
		boolean[][] dp = new boolean[len + 1][sum + 1];

		// if sum is zero
		// then the first column of the matrix filled with true
		for (int i = 0; i <= len; i++) {
			dp[i][0] = true;
		}

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;

		// fill the rest of the block using bottom up manner
		for (int i = 1; i <= len; i++) {

			// consider all sum from 1 to sum
			for (int j = 1; j <= sum; j++) {

				// don't include ith element if A[i-1] > j
				if (arr[i - 1] > j) {

					dp[i][j] = dp[i - 1][j];
				} else {

					// find subset with sum j by excluding or including
					// the ith item
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		// return the last gilled value
		return dp[len][sum];

	}

	public static void main(String[] args) {

		// Input Array
		int[] arr = { 7, 3, 2, 5, 8 };
		int sum = 18;

		if (subsetSum(arr, sum))
			System.out.println("True");// if subset contain the sum
		else
			System.out.println("False");
	}

}
