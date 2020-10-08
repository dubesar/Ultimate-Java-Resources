import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());

        double median = 0;
        double[] res = new double[a.length];
        for (int i=0; i<a.length; i++) {
                if (a[i] <= median) {
                        smaller.offer(a[i]);
                } else {
                        higher.offer(a[i]);
                }

                if (higher.size() > smaller.size()+1) {
                        smaller.offer(higher.poll());
                }
                if (smaller.size() > higher.size()+1) {
                        higher.offer(smaller.poll());
                }

                if (higher.size() == smaller.size()) {
                        median = (smaller.peek() + higher.peek())/2.0;
                } else if(higher.size() > smaller.size()) {
                        median = (double)higher.peek();
                } else if (higher.size() < smaller.size()) {
                        median = (double)smaller.peek();
                }
                res[i] = (median);
        }
        return res;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
