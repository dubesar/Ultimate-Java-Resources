import java.util.Scanner;
public class LinearSearch
{
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0;i<arr.size();i++)
		{
			arr[i] = input.nextInt();
		}
		int item = sc.nextInt();
		int idx = linearsearch(arr,item);
		if(idx != -1){
			System.out.println(idx)
		}else{
			System.out.println("Element is not Present")
		}

	} 
	public static int linearsearch(int[] arr,int item)
	{
		for(int ptr=0;ptr<=arr.length;ptr++)
		{
			if(arr[ptr] == item)
			{
				return ptr;
			}
		}
		return -1;
	}
}