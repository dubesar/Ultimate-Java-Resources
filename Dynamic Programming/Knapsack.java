/*

Probelm Statement:
    Given: N items with specified weights W_i and profits P_i.
    Task: Fill a Knapsack with maximum capacity W using these items and achieve maximum profit.
    Conditions: An item is either included or excluded i.e. 0/1


Solution:
    Using Bottom-Up Dynamic Programming:
        Start with a weight, consider either taking the weight or excluding the weigh
        select max of both values and proceed to fill the memoization table
*/


class Knapsack { 
  
    // A Customized max function to return max value of a & b
    static int max(int a, int b) {
        if(a > b) return a;
        return b;
    }

   // Bottom up DP function which returns maximum profit of knapsack

    static int knapSack(int W, int weights[], int profits[], int n) { 
        int i, w;

        int K[][] = new int[n+1][W+1]; // A Memoization table for bottom up dp 
        
        // Bottom up Loop to calculate the maximum profit
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0) { // Fill the first row and first column with 0's
                    K[i][w] = 0; 
                }
                else if (weights[i-1] <= w) { // consider this weight and find max of considered and unconsidered states
                    K[i][w] = max(profits[i-1] + K[i-1][w-weights[i-1]],  K[i-1][w]); 
                }
                else { // leave this weight and copy the value without this weight as it is
                   K[i][w] = K[i-1][w]; 
                }
            } 
        }
       
      return K[n][W]; 
    } 
  
    
    // Main function of the code
    public static void main(String args[]) {
        int N = 3; // 3 items to be considered

        int profits[] = new int[]{45, 115, 130}; // Declare and initialize the profit array

        int weights[] = new int[]{10, 20, 30}; // Initializing the weights for each item 
        
        int  W = 50; // Maximum capacity of the Knapsack

        System.out.println("The maximum profit obtained is: "+ knapSack(W, weights, profits, N)); 
    } 
}
