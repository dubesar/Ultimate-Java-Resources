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
     * Complete the 'getMinEffort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY C as parameter.
     */

    
public static int getMinEffort(List<List<Integer>> C) {
    // Write your code here
        int m = C.size();
        int n = C.get(0).size();
        
        int[][] maxW = new int[m][n];
        
        for(int[] row : maxW)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        maxW[0][0] = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->{
            return a[0] - b[0];
        });
        
        q.add(new int[]{0,0,0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[1];
            int j = curr[2];
            visited[i][j] = true;
            
            if(i == m-1 && j == n-1){
                return maxW[i][j];
            }
            
            if(i-1 >= 0 && !visited[i-1][j]){
                maxW[i-1][j] = Math.min(maxW[i-1][j],Math.max(maxW[i][j],Math.abs(C.get(i).get(j)-C.get(i-1).get(j))));
                q.add(new int[]{maxW[i - 1][j],i-1,j});
            }
            
            if(i+1 < m && !visited[i+1][j]){
                maxW[i+1][j] = Math.min(maxW[i+1][j],Math.max(maxW[i][j],Math.abs(C.get(i).get(j)-C.get(i+1).get(j))));
                q.add(new int[]{maxW[i + 1][j],i+1,j});
            }
            
            if(j-1 >= 0 && !visited[i][j-1]){
                maxW[i][j-1] = Math.min(maxW[i][j-1],Math.max(maxW[i][j],Math.abs(C.get(i).get(j)-C.get(i).get(j-1))));
                q.add(new int[]{maxW[i][j - 1],i,j-1});
            }
            
            if(j+1 < n && !visited[i][j+1]){
                maxW[i][j+1] = Math.min(maxW[i][j+1],Math.max(maxW[i][j],Math.abs(C.get(i).get(j)-C.get(i).get(j+1))));
                q.add(new int[]{maxW[i][j + 1],i,j+1});
            }
        }
        
        return 0;
    }



}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int answer = Result.getMinEffort(arr);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
