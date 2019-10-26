import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a list of coins of distinct denominations and total amount of money. Output the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins.
 * You may assume that there are infinite numbers of coins of each type.
 *
 * Input:
 * The first line contains 'T' denoting the number of testcases. Then follows description of testcases.
 * Each cases begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins and total amount of money respectively.
 * The second line contains n space-separated integers A1, A2, ..., An denoting the values of coins.
 *
 * Output:
 * For each testcase, in a new line, print the minimum number of coins required to make up that amount, print -1 if it is impossible to make that amount using given coins.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=n<=100
 * 1<=Ai<=1000
 * 1<=amount<=100000
 *
 * Example:
 * Input :
 * 2
 * 3 11
 * 1 2 5
 * 2 7
 * 2 6
 * Output :
 * 3
 * -1
 */


public class MakeChange {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while ( t-- > 0){

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int n = Integer.parseInt(strs[0]);
            int sum = Integer.parseInt(strs[1]);

            line = br.readLine();
            strs =  line.trim().split("\\s+");

            int[] a = new int[n];

            for (int i=0; i<n; i++){
                a[i] = Integer.parseInt(strs[i]);
             }


             System.out.println(minCoin(n, sum, a));



        }

    }

    private static int minCoin(int n, int sum, int[] a) {

        int[] lookup  = new int[sum+1];

        for(int i=0; i<sum+1; i++){
            lookup[i] = Integer.MAX_VALUE;
        }

        lookup[0] = 0;

        for (int i=1; i<sum+1; i++){
            minCoinUtil(i, lookup, a, n);
        }

        return lookup[sum] == Integer.MAX_VALUE? -1:lookup[sum];
    }

    private static void minCoinUtil(int k, int[] lookup, int[] a, int n) {

        int min = Integer.MAX_VALUE;

        for (int i=0; i<n; i++){
            if(k-a[i] < 0 || lookup[k-a[i]] == Integer.MAX_VALUE)
                continue;

            if (1+lookup[k - a[i]] < min){
                min = 1+ lookup[k -a[i]];
            }
        }

        lookup[k] = min;
    }


}
