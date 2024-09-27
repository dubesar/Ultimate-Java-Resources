/*
The problem is to check if there is a subset in the given array whose sum is equal to the given number
For ex: if array is {{10, 3, 7, 6, 4, 8, 1} and given sum is 15, we have to return true since there is a subset of the array with sum 15 i.e (10,4,1)
We can solve this via Dynamic Programming!
We can divide the problem into two subproblems
1) include the last element recur for n-1 elements with sum = sum – arr[n-1]
2) Exclude the last element, recur for n-1 elements with the original sum.
So every possible combination will be tried out including and excluding each element, hence the time complexity will be 2^n
*/
class SubsetSum {
    public static boolean checkSubsetSum(int [] arr, int sum, int n) {
        //Base cases
        // if sum has become zero, subset with the given sum exists
    	if(sum == 0) 
    	return true;
        // if the element itself is greater than the sum, exclude it
    	else if(arr[n-1] > sum)
    	return false;
        // if sum is not 0 but all elements have been traversed
    	else if(n == 0)
    	return false;
    	else
    	// recur for n-1 elements
        return checkSubsetSum(arr , sum-arr[n-1], n-1) || checkSubsetSum(arr, sum, n-1);
        
    }
    public static void main(String arg[]) {
        int [] arr = {10, 3, 7, 6, 4, 8, 1};
        int sum = 15;
        System.out.println("Subset with the given sum exists "+checkSubsetSum(arr, sum, arr.length));
    }
}
