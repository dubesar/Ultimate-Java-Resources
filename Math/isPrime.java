public class isPrime
{
	//Returns true if number is prime numer - otherwise false
	//Values below 2 return false.
	public static boolean isPrime(int number)
	{
		if(number < 2)
			return false;
		for(int i = 2; i < number; i++)
		{
			if(number % i == 0)
				return false;
		}
		return true;
	}
}