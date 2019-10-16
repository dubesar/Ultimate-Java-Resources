import java.util.Scanner;
import java.lang.Math;
class MillerRabinTest
{
	public static int power(int a,int n, int p) 
    {
        int res = 1; 
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

	public static boolean millerTest(int d, int n)
	{ 
        int a = 2 + (int)(Math.random() % (n - 4));
        int x = power(a, d, n);
        if (x == 1 || x == n - 1) 
            return true; 
        while (d != n - 1)
        { 
            x = (x * x) % n;
            d *= 2;
            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }
        return false; 
    } 
      
    static boolean isPrime(int n, int k)
    {
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;
        int d = n - 1;
        while (d % 2 == 0)
            d /= 2;
        for (int i = 0; i < k; i++)
            if (!millerTest(d, n))
                return false;
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