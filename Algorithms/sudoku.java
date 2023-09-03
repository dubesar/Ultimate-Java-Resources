/*Java Program to solve Sudoku problem using Backtracking*/
public class Main
{
	public static boolean isValid(int[][] puzzle,int row, int col,int number)
	{
		// Row has the unique
		for (int d = 0; d < puzzle.length; d++)
		{

			/* If the number we are trying to
			 place is already present in
			 that row, then return false;*/
			if (puzzle[row][d] == number) {
				return false;
			}
		}
		// Column has the unique numberbers
		for (int r = 0; r < puzzle.length; r++)
		{
			 /* If the number we are trying to
			 place is already present in
			 that column, then return false;*/
			if (puzzle[r][col] == number)
			{
				return false;
			}
		}

		//Corresponding square has unique number
		int sqrt = (int)Math.sqrt(puzzle.length);
		int bRow = row - row % sqrt;
		int bCol = col - col % sqrt;
		for (int r = bRow;
			r < bRow + sqrt; r++)
		{
			for (int d = bCol;
				d < bCol + sqrt; d++)
			{
				if (puzzle[r][d] == number)
				{
					return false;
				}
			}
		}
		// if there is no clash, it's safe
		return true;
	}
	public static boolean solution(int[][] puzzle, int n)
	{
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (puzzle[i][j] == 0)
				{
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}
		// No empty space left
		if (isEmpty)
		{
			return true;
		}
		// Else backtrack for each-row
		for (int number = 1; number <= n; number++)
		{
			if (isValid(puzzle, row, col, number))
			{
				puzzle[row][col] = number;
				if (solution(puzzle, n))
				{
					// print(puzzle, n);
					return true;
				}
				else
				{
					// replace it
					puzzle[row][col] = 0;
				}
			}
		}
		return false;
	}
    //To Print the Sudoku
	public static void printSudoku(int[][] puzzle, int N)
	{
		for (int r = 0; r < N; r++)
		{
			for (int d = 0; d < N; d++)
			{
				System.out.print(puzzle[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int)Math.sqrt(N) == 0)
			{
				System.out.print("");
			}
		}
	}

	// Driver Code
	public static void main(String args[])
	{
        //Here 0 represents the unassigned value
		int[][] puzzle = new int[][] {
			{ 3, 0, 5, 4, 0, 2, 0, 6, 0 },
			{ 4, 9, 0, 7, 6, 0, 1, 0, 8 },
			{ 6, 0, 0, 1, 0, 3, 2, 4, 5 },
			{ 0, 0, 3, 9, 0, 0, 5, 8, 0 },
			{ 9, 6, 0, 0, 5, 8, 7, 0, 3 },
			{ 0, 8, 1, 3, 0, 4, 0, 9, 2 },
			{ 0, 5, 0, 6, 0, 1, 4, 0, 0 },
			{ 2, 0, 0, 5, 4, 9, 0, 7, 0 },
			{ 1, 4, 9, 0, 0, 7, 3, 0, 6 }
		};
		int N = puzzle.length;
        System.out.println("Before Solving");
        printSudoku(puzzle, N);
        System.out.println("");
        System.out.println("After Solving");
		if (solution(puzzle, N))
		{
			printSudoku(puzzle, N);
		}
		else
		{
			System.out.println("No solution exists");
		}
	}
}
