/* PROBLEM STATEMENT: Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of 
values on each face when all the dice are thrown.

Time Complexity: O(m * n * x) where m is number of faces, n is number of dice and x is given sum. */


import java.util.*; 
import java.lang.*; 
import java.io.*; 

class GFG { 
	
	public static long findWays(int m, int n, int x){ 
		
	/* Create a table to store the results of subproblems. 
	One extra row and column are used for simplicity 
	(Number of dice is directly used as row index and sum is directly used as column index). 
	The entries in 0th row and 0th column are never used. */
	long[][] table = new long[n+1][x+1]; 
		
	/* Table entries for only one dice */
	for(int j = 1; j <= m && j <= x; j++) 
				table[1][j] = 1; 
			
	/* Fill rest of the entries in table using recursive relation 
	i: number of dice, j: sum */
	for(int i = 2; i <= n;i ++){ 
				for(int j = 1; j <= x; j++){ 
					for(int k = 1; k < j && k <= m; k++) 
						table[i][j] += table[i-1][j-k]; 
				} 
		} 
		
		
		return table[n][x]; 
	} 
	
	public static void main (String[] args) { 
		System.out.println(findWays(4, 2, 1)); 
		System.out.println(findWays(2, 2, 3)); 
		System.out.println(findWays(6, 3, 8)); 
		System.out.println(findWays(4, 2, 5)); 
		System.out.println(findWays(4, 3, 5)); 
	} 
} 

