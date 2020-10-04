import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int hourglassSum(int[][] a) {
        int MAX = Integer.MIN_VALUE;
        int i,j;
        for(i=0;i<6-2;i++){
            for(j=0;j<6-2;j++){
                int sum = (a[i][j]+a[i][j+1]+a[i][j+2]  + a[i+1][j+1]  +  a[i+2][j]+a[i+2][j+1]+a[i+2][j+2]);
                MAX = Math.max(MAX,sum);
            }
        }
        return MAX;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
