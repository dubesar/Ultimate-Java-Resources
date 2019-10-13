public class NthPrime
{
    //-------------------------------------
    // Finds the nth prime number for user-inputted value of n
    //-------------------------------------
    public static int FindNthPrime(int num)
    {
        int primeCount = 0, i = 1;

        //Check all numbers until n primes are found.
        while (primeCount < num)
        {
            i++;
            //Increment the number of primes found if the number is prime.
            if (isPrime(i))
                primeCount++;
        }

        //Return the nth prime number.
        return i;
    }

    //--------------------------------------
    // Helper method for FindNthPrime
    // Returns true if the number is prime, false otherwise
    //--------------------------------------
    private static boolean isPrime(int num)
    {
        //Check for integer divisors of num
        for (int i = 2; i < num; i++)
        {
            //If num is divisible by any number between 1 and num, the number is not prime
            if (num % i == 0)
                return false;
        }
        //If no integer divisors are found, the number is prime.
        return true;
    }
}