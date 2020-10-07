public class LongestCommonSubsequence {

    /**
     * Given 2 string get the length of the longest subsequence that occurs in both the Strings
     * 
     * For Example :
     * 1 - LCS("abcde","ace") = "ace", so the program return 3
     * 2 - LCS("abcd", "abcd") = "abcd" so the program return 4
     * 3 - LCS("abc", "def") = "" it return 0 as there is no common subsequence in both the Strings.
     *             
     *  */ 
    public int longestCommonSubsequence(String s1, String s2) 
    {
        int rows = s1.length();        
        int cols = s2.length();                        
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();

        //2d array to keep track of max count of subsequence encountered so far.
        int[][] dp = new int [rows][cols];
        
                   
        for(int i=0; i<rows;i++)
           {
               for(int j=0; j<cols;j++)
               {
                   if(s[i]==t[j])
                   {
                       if(check(i-1,rows) && check(j-1,cols))
                       {
                           dp[i][j]=dp[i-1][j-1]+1;
                       }
                       else
                           dp[i][j]=1;
                   }
                   else
                   {
                       int up = check(i-1,rows)?dp[i-1][j]:0;
                       int down = check(j-1,cols)?dp[i][j-1]:0;
                       
                       dp[i][j]=Math.max(up,down);
                   }
               }
           }
           
           return dp[rows-1][cols-1];
    }
           
    //helper function to check for index within bounds       
    public static boolean check(int n, int len)
    {
        return 0<=n && n<len;
    }           
}