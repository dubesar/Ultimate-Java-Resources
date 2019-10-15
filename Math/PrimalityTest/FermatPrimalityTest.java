import java.util.Scanner;
import java.lang.Math;
class FermatPrimalityTest
{
	static int power(int a,int n, int p) 
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

	public static boolean isPrime(int n, int k)
	{
		if (n <= 1 || n == 4) return false; 
	    if (n <= 3) return true;
	    while (k > 0) 
	    { 
	        int a = 2 + (int)(Math.random() % (n - 4));
	       	if (power(a, n - 1, n) != 1) 
	            return false;
	        k--; 
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