/* 
    Brain Kernighan Algorithm is used to count the
    No. of 1's or set bits in an Integer.

    e.g., 6 = 110
    Therefore, No. of set bits in 6 = 2

*/
public class Brian_Kernighan {
    
    static int countSetBits(int n) {

        int count = 0;

        while(n > 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        
        int n = 6;
        int result = countSetBits(n);
        System.out.println("There are " + result + " set bits or 1's in " + n);

    }

}
