// Java program to solve Gold Mine problem 
import java.util.Arrays; 

class GoldMine { 
	
	static final int MAX = 100; 
	
	// Returns maximum amount of gold that 
	// can be collected when journey started 
	// from first column and moves allowed 
	// are right, right-up and right-down 
	static int getMaxGold(int gold[][], int m, int n) 
	{
		int goldTable[][] = new int[m][n]; 
		
		for(int[] rows:goldTable) 
			Arrays.fill(rows, 0); 
	
		for (int col = n-1; col >= 0; col--) 
		{ 
			for (int row = 0; row < m; row++) 
			{ 
				
				// Gold collected on going to the cell on the right
				int right = (col == n-1) ? 0: goldTable[row][col+1]; 
	
				// Gold collected on going to the cell to right up 
				int right_up = (row == 0 || col == n-1) ? 0 :goldTable[row-1][col+1]; 
	
				// Gold collected on going to the cell to right down 
				int right_down = (row == m-1|| col == n-1) ? 0 :goldTable[row+1][col+1]; 
	
				// Max gold collected from taking either of the above 3 paths 
				goldTable[row][col] = gold[row][col]+ Math.max(right, Math.max(right_up,right_down)); 
														 
			} 
		} 
	
		// The max amount of gold collected will be 
		// the max value in first column of all rows 
		int res = goldTable[0][0]; 
		
		for (int i = 1; i < m; i++) 
			res = Math.max(res, goldTable[i][0]); 
			
		return res; 
	} 
	
	//driver code 
	public static void main(String arg[]) 
	{ 
		int gold[][]= { {1, 6, 0, 8}, 
				{3, 2, 4, 1}, 
				{9, 0, 2, 3}, 
				{0, 6, 1, 2} }; 
						
		int m = 4, n = 4; 
		
		System.out.print(getMaxGold(gold, m, n)); 
	} 
} 


