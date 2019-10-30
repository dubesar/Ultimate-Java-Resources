// This algorithm solves this problem:
// + "Given a rod of length n and an array that contains prices of all pieces of size
// smaller than n. Determine the maximum value obtainable by cutting up the rod and selling
// the pieces."
public class RodCutting 
{
	// This solution is correct but highly inefficient. Recursive calls aren't memoized
	// so the poor code has to solve the same subproblem every time there's a single
	// overlapping solution.
    public int byRecursionApproach(int[] values, int length) {
        if (length <= 0)
            return 0;
        int tmpMax = -1;
        for (int i = 0; i < length; i++) {
            tmpMax = Math.max(tmpMax, values[i] + byRecursionApproach(values, length - i - 1));
        }
        return tmpMax;
    }

    // With this approach we eliminate the need for recursive calls by solving the subproblems
    // from the ground-up, utilizing the fact that all previous subproblems to a given problem
    // are already solved. It follows the same basic principle from above, but adds memoization
    // and excludes recursive calls.
    public int byDynamicApproach(int[] values, int length) {
        int[] subSolutions = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++)
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            subSolutions[i] = tmpMax;
        }
        return subSolutions[length];
    }
    
	public static void main(String args[]) 
	{ 
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
		int size = arr.length; 
		
		RodCutting rodCutting = new RodCutting();
		System.out.println("Maximum obtainable value by recursion: " + rodCutting.byRecursionApproach(arr, size)); 
		System.out.println("Maximum obtainable value by dynamic programming: " + rodCutting.byDynamicApproach(arr, size));
	} 
} 
