import java.util.*;

public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> li = new ArrayList<Integer>();
        for(int i = 0;i<n;i++){
            int k = sc.nextInt();
            li.add(i,k);
        }
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            String s = sc.next();
            if(s.compareTo("Insert")==0){
                int p = sc.nextInt();
                int l = sc.nextInt();
                li.add(p,l);
            }
            else{
                int p = sc.nextInt();
                li.remove(p);
            }
        }
        li.forEach(nb -> System.out.print(nb + " "));
    }
}
