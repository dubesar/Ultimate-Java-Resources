public class SubsetSum {
    /* Driver function to test the isSubsetSum function */
    public static void main (String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum)) {
            System.out.println("Found a subset" + " with given sum");
        }
        else {
            System.out.println("No subset with" + " given sum");
        }
    }

    public static boolean isSubsetSum(int set[], int n, int sum){
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++){
            subset[0][i] = true;
        }

        // Fill the subset table in botton-up manner
        for (int i = 1; i <= sum; i++){
            for (int j = 1; j <= n; j++){
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][n];
    }
}
