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
     * Complete the 'countCups' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY balls
     *  3. 2D_INTEGER_ARRAY swaps
     *  4. 2D_INTEGER_ARRAY queries
     */
    

    

    public static List<Integer> countCups(int n, List<Integer> balls, List<List<Integer>> swaps, List<List<Integer>> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int b:balls){
            set.add(b);
        }
        //System.out.println(set);
        for(List<Integer> l : swaps){
            int a = l.get(0);
            int b = l.get(1);
            if(set.contains(a) && !set.contains(b)){
                //System.out.println(a +  " " + b);
                set.remove(a);
                set.add(b);
            }else if(set.contains(b) && !set.contains(a)){
               // System.out.println(b +  " " + a);
                set.remove(b);
                set.add(a);
            }
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int x : set)
            map.put(x,0);
        
        map.put(0,0);
        int count = 0;
        
        for(int x : map.keySet())
            map.put(x,++count);
        
        List<Integer> ans = new ArrayList<>();
        
        for(List<Integer> q : queries){
            int l = q.get(0)-1;
            int r = q.get(1);
            
            Integer count_left = 0;
            Integer count_right = 0;
            
            if((count_left = map.get(l)) == null){
                count_left = map.get(map.floorKey(l));
            }
            
            if((count_right = map.get(r)) == null){
                count_right = map.get(map.floorKey(r));
            }
            
            ans.add(count_right-count_left);
        }
        
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int s = Integer.parseInt(firstMultipleInput[2]);

        int q = Integer.parseInt(firstMultipleInput[3]);

        List<Integer> balls = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> swaps = new ArrayList<>();

        IntStream.range(0, s).forEach(i -> {
            try {
                swaps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> query = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                query.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.countCups(n, balls, swaps, query);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
