import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'arrangeStudents' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
        int n = a.size();
        Integer ar[] = new Integer[n];
        Integer br[] = new Integer[n];
        int cr[] = new int[n+n];
        
        Collections.sort(a);
        Collections.sort(b);
        a.toArray(ar);
        b.toArray(br);
        int j=0;
        for(int i=0;i<n;i++){
            cr[j++]=ar[i];
            cr[j++]=br[i];
        }
        int flag1 =1;
        for(int i=0;i<n*2-1;i++){
            if(cr[i]>cr[i+1])
                flag1 =0;
        }
        int flag2 = 1;
        j=0;
        for(int i=0;i<n;i++){
            cr[j++]=br[i];
            cr[j++]=ar[i];
        }
        for(int i=0;i<n*2-1;i++){
            if(cr[i]>cr[i+1])
                flag2 =0;
        }
        if(flag1 == 1 || flag2==1)
            return "YES";
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.arrangeStudents(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
