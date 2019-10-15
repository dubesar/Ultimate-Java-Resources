import java.util.Scanner;
import java.lang.Math;
class BasicPrimalityTest
{
	public static boolean isPrime(int n)
	{
		if (n == 1)
			return false;
		boolean prime = true;
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				prime = false;
				break;
			}
		}
		return prime;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num;
		num = sc.nextInt();
		if(isPrime(num))
			System.out.println("Number is Prime");
		else
			System.out.println("Number is not Prime");
	}
}