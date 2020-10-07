import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                // -15 to left justify the string 
                // 03 to express the number with 3 digits 
                System.out.format("%-15s%03d%n", s1, x);
            }
            System.out.println("================================");

    }
}
