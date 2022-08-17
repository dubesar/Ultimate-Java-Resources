
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        boolean result = true;
        int sz = 26;
        int [] count = new int[sz];
        if(a.length()!=b.length()) result = false;
        for(int i=0;i<a.length() && i<b.length();i++){
            count[a.toLowerCase().charAt(i) % 26]++;
            count[b.toLowerCase().charAt(i) % 26]--;
        }
        for(int k=0;k<sz;k++){
            if (count[k] != 0) {
                result = false;
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
