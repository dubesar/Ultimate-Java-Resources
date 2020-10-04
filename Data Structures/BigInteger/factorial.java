//Calculating 30! using BigInteger
import java.math.BigInteger; 
import java.util.Scanner; 
public class Example{ 
    static BigInteger factorial(int n){ 
        BigInteger fact = new BigInteger("1"); // Or BigInteger.ONE 
        for (int i = 2; i <= n; i++) 
            fact = fact.multiply(BigInteger.valueOf(i)); 
        return fact; 
    } 
  
    public static void main(String args[]) throws Exception { 
        int n = 30; 
        System.out.println(factorial(n)); 
    } 
} 
/*
Output
265252859812191058636308480000000
*/
