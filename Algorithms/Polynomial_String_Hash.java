import java.io.*;
// Java implementation of the Polynomial Rolling Hash Function

public class Polynomial_String_Hash
{
	// Function to calculate the hash value 
	static long calculateHash(String str)
	{	
		int p = 31;             // P a prime close to 26, the total number of alphabets
		int m = (int)(1e9 + 9); // A large prime number
		long power_of_p = 1; 
		long hash_val = 0;

		// Loop to calculate the hash value by iterating over the elements of String
		for(int i = 0; i < str.length(); i++) 
		{
			hash_val = (hash_val + (str.charAt(i) - 'a' + 1) * power_of_p) % m; // Replace 'a' with 'A' in case the string is uppercase
			power_of_p = (power_of_p * p) % m;
		}
		return hash_val;
	}
	public static void main(String[] args) // Driver Code for testing the above algorithm
	{
		String str1 = "dubesar";
		String str2 = "java";
		System.out.println("Hash of '" + str1 + "' = " + calculateHash(str1));
		System.out.println("Hash of '" + str2 + "' = " + calculateHash(str2));
	}
}