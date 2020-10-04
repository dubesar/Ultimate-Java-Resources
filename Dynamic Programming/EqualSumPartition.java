/* PROBLEM STATEMENT : DIVIDE THE ARRAY INTO TWO PARTITION OF EQUAL SUM.
//Key Points :
1 : THE PROBLEM IS SIMILAR TO THE SUBSET SUM PROBLEM WITH A LIITLE MODIFICATION
                    ARRAY ARR(2s)
                    /      \
                   /        \
                  /          \
               Partition 1   Partition 2
                Sum : s        Sum : s
2 : WE CONCLUDE THAT THE SUM OF ARRAY SHOULD BE EVEN TO BE ABLE TO PARTIONED.
3 : IT IS SIMILAR TO SUBSET SUM PROBLEM AS WE NEED TO FIND A SUBSET OF SUM sum/2.
 */
public class EqualSumPartition {

    //***********************************************Recursive Approach**********************************************************
    private static boolean solveRecursively(int arr[], int i, int sum) {
        //If at some point we have (sum == 0) it means we have found a subset of given sum in the array.So we return true
        if (sum == 0) {
            return true;
        }
        //The i == 0 will get executed only when we have no more elements left in the array and we couldnt find the required sum. So we return false;
        if (i == 0) {
            return false;
        }
        //If the given element is valid i.e it is less than our required sum. We solve the problem recursively. We have two possible choice:
        //Include the element OR exclude it.
        if (arr[i - 1] <= sum) {
            return solveRecursively(arr, i - 1, sum - arr[i - 1]) | solveRecursively(arr, i - 1, sum);
        } else {
            return solveRecursively(arr, i - 1, sum); //As the element is invalid we do not include
        }
    }

    //***********************************************Dynamic Programming Approach**********************************************************
    private static boolean solveUsingDp(int arr[], int sum) {
        //The bottom up dynamic programming approach is similar to the subset sum problem.
        //The state dp[i][j] will be true if there a subset of first i items with sum value = j.
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) //base case. Evident from our recurive approah
                {
                    if (i == 0) // the case when there are no it
                    {
                        dp[i][j] = false;
                    }
                    if (j == 0) {
                        dp[i][j] = true; //The case when sum = 0. We always have a empty subset {} with sum 0.
                    }
                } else {
                    if (arr[i - 1] <= j) //If the element is valid. We will find subset of sum j by including or excluding the ith item
                    {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] | dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j]; //We dont include the ith item as its invalid
                    }
                }

            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 6}, sum = 0;

        //We find the sum of each element of array.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        //As explained at top : A partition with equal sum would only exist when the sum is an even number
        if (sum % 2 != 0) {
            System.out.println(0);
        } else {
            System.out.println(solveRecursively(arr, arr.length, sum / 2)); //Recursive Approach
            System.out.println(solveUsingDp(arr, sum / 2)); //Bottom up dynamic programming approach.
        }
    }
}
