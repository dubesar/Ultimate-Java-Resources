
import java.util.Random;

// Java program for implementation of Fisher-Yates shuffle
public class Shuffle
{ 
	public void shuffle(int arr[])
	{
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		Shuffle shuffle = new Shuffle();
		shuffle.shuffle(arr);

		System.out.println("Shuffled array:");
		printArray(arr); 
	} 
}
