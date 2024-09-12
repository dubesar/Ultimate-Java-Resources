class Knapsack 
{ 
    static int max(int a, int b) { return (a > b)? a : b; } 
       
   // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int i, w; 
        int K[][] = new int[n+1][W+1]; //Table for calculating the profit in Knapsack
       
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++) 
        { 
            for (w = 0; w <= W; w++) 
            { 
                if (i==0 || w==0) 
                    K[i][w] = 0;         //If there are no items or the weight is zero then profit is zero
                else if (wt[i-1] <= w) 
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); //Take maximum value of (When the weight is included,When the weight is not included)
                else
                    K[i][w] = K[i-1][w]; //If weight of the nth item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
            } 
        } 
       
        return K[n][W]; //Return the last cell of table as it gives profit when weight = W and all items are selected
    } 
   
    public static void main(String args[]) 
    { 
        int values[] = new int[]{50, 150, 220}; 
        int weights[] = new int[]{10, 30, 40}; 
        int  W = 40; 
        int n = values.length; 
        System.out.println(knapSack(W, weights, values, n)); 
    } 
} 