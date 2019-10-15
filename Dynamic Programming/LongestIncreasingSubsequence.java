class LongestIncreasingSubsequence {

    // table for dynamic programming
    public int [] dp;
    
    public int lis(int [] arr, int n) {
        // base case for dynamic programming
        if (arr.length-1 == n) {
            dp[n] = 1;
            return 1;
        }
        
        // call recursively itself with
        lis(arr, n + 1);
        
        // initialize current dp value
        dp[n] = dp[arr.length-1];
        
        // cycle that searches for bigger value than current value and dp of that value should be bigger than current one
        for (int j = n; j < arr.length; j++) {            
            if (arr[j] > arr[n] && dp[j] + 1 > dp[n]) {
                dp[n] = dp[j] + 1;                
            }
        }        
        return dp[n];
    }
    
    // main method that calculates LIS for given array in nums
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        
        // edge case
        if (n == 0) return 0;
        
        // initialize the dp table
        dp = new int[n];
        
        // call the recursive LIS method
        lis(nums, 0);
        
        // return the maximum value from dp table
        return Arrays.stream(dp).max().getAsInt();
    }
}
