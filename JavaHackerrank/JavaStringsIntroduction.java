import java.util.*;

public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(a.length()+b.length());
        if(a.compareTo(b)>0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        String a1 = Character.toString(a.charAt(0));
        String b1 = Character.toString(b.charAt(0));
        String s1 = a1.toUpperCase()+a.substring(1);
        String s2 = b1.toUpperCase()+b.substring(1);
        System.out.println(s1+" "+s2);
    }
}
