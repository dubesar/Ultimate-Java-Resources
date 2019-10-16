/*

Probelm Statement:
    Given: (2 x n) board and tiles of size (2 x 1)
    Task: Count the number of ways to tile the given board using the 2 x 1 tiles.
    Conditions: A tile can either be placed horizontally as (1 x 2) tile or vertically as (2 x 1) tile.


Solution:
    If we place 1 tile vertically, it occupies (2 x 1) area
                        OR
    We can place 2 tiles horizontally, one above another to cover (2 x 2) area
    
    There is no other way

    so we form our recursion so as to count the number of ways to to fill the board horizontally with
    either 1's or 2's 

    Recurrence Equation:
        count(n) = count(n-1) + count(n-2)

    Base conditions: 
        if n == 1, return 1
        if n == 2, return 2

    Bottom Up DP Approach:
        We can calculate the values while looping over 1 to N considering required lookbacks
*/

class TilingProblem {

   // start from bottom and calculate for each step using previous result
    static int solve(int n) { 
        int dp[] = new int[n+1];
        dp[1]=1; dp[2]=2; // Preconditions and initializations

        for(int i=3;i<=n;i++) {
            dp[i]=dp[i-1]+dp[i-2]; //using the recurence equation to transform to iterative solution
        }

        return dp[n]; // finally return the solution for the query value N
    } 
  
    
    // Main function of the code
    public static void main(String args[]) {
        
        int n, total_number_of_ways; 
    
        n = 12; // The board is of size (2 x 12)

        total_number_of_ways = solve(n); // Calling the solve function with parameter value N

        System.out.println("The Total Number of ways to Tile the board are: "+total_number_of_ways); 
    } 
}