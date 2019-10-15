import java.util.Scanner;
import java.util.Random;
class SolovayStrassenTest
{
	public static long power(long a,long n, long p) 
    {
        long res = 1; 
        a = a % p;
        while (n > 0) 
        {
            if ((n & 1) == 1) 
                res = (res * a) % p; 
            n = n >> 1;
            a = (a * a) % p; 
        } 
        return res; 
    }

    public static long calculateJacobian(long a, long b)
	{
		if (b <= 0 || b % 2 == 0)
            return 0;
        long j = 1L;
        if (a < 0)
        {
            a = -a;
            if (b % 4 == 3)
                j = -j;
        }
        while (a != 0)
        {
            while (a % 2 == 0)
            {
                a /= 2;
                if (b % 8 == 3 || b % 8 == 5)
                    j = -j;
            }
            long temp = a;
            a = b;
            b = temp;
            if (a % 4 == 3 && b % 4 == 3)
                j = -j;
            a %= b;
        }
        if (b == 1)
            return j;
        return 0;
	} 

	public static boolean isPrime(int n, int k)
	{
		if (n < 2)
	        return false;
	    if (n != 2 && n % 2 == 0)
	        return false;
	    Random rand = new Random();
	    for (int i = 0; i < k; i++)
	    {
	        long a = Math.abs(rand.nextLong()) % (n - 1) + 1;
	        long jacobian = (n + calculateJacobian(a, n)) % n;
	        long mod = power(a, (n - 1) / 2, n);
	        if (jacobian == 0 || mod != jacobian)
	            return false;
	    }
	    return true;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num;
		num = sc.nextInt();
		if(isPrime(num, 50))
			System.out.println("Number is Prime");
		else
			System.out.println("Number is not Prime");
	}
}