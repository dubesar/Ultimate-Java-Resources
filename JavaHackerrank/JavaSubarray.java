import java.util.*;

public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>(n);
        for(int i = 0; i<n ; i++){
            int s = sc.nextInt();
            a.add(s);
        }
        int tot = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int sum = 0;
                for(int k = i;k<=j;k++){
                    sum+=a.get(k);
                }
                if(sum<0){
                    tot++;
                }
            }
        }
        System.out.println(tot);
    }
}
