// Java program to the nth prime number using Sieve of Eratosthenes
import java.util.ArrayList;
import java.util.Scanner;

class Sieve
{

    // initializing the max value  
    static int MAX_SIZE = 1000005;

    // To store all prime numbers 
    static ArrayList<Integer> primes = new ArrayList<Integer>();

    // Function to generate N prime numbers  
    // using Sieve of Eratosthenes 
    static void SieveOfEratosthenes()
    {
        // Create a boolean array "IsPrime[0..MAX_SIZE]"  
        // and initialize all entries it as true.  
        // A value in IsPrime[i] will finally be false  
        // if i is Not a IsPrime, else true.  
        boolean [] IsPrime = new boolean[MAX_SIZE];

        for(int i = 0; i < MAX_SIZE; i++)
            IsPrime[i] = true;

        for (int p = 2; p * p < MAX_SIZE; p++)
        {
            // If IsPrime[p] is not changed,  
            // then it is a prime  
            if (IsPrime[p] == true)
            {
                // Update all multiples of p greater than or  
                // equal to the square of it  
                // numbers which are multiple of p and are  
                // less than p^2 are already been marked.  
                for (int i = p * p; i < MAX_SIZE; i += p)
                    IsPrime[i] = false;
            }
        }

        // Store all prime numbers  
        for (int p = 2; p < MAX_SIZE; p++)
            if (IsPrime[p] == true)
                primes.add(p);
    }

    // Driver Code 
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();

        // Function call 
        SieveOfEratosthenes();

        System.out.println("Nth prime number is " + primes.get(N-1));
    }
}
