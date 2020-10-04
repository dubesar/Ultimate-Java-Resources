import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int query = sc.nextInt();
        Queue<Integer>q = new LinkedList<>();
        while(query--!=0){
            int n = sc.nextInt();
            if(n==1){
                int add = sc.nextInt();
                q.add(add);
            }else if(n==2){
                q.remove();
            }else if(n==3){
                System.out.println(q.peek());
            }
        }
    }
}