import java.util.Scanner;
public class BinarySearch
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,2,3,4,56,66,78,99,1010,7008,7456,10001};
		int item = sc.nextInt();
		int idx = binarysearch(arr,item);
		if(idx != -1){
			System.out.println(idx)
		}else{
			System.out.println("Element is not Present")
		}
	}
	public static int binarysearch(int[] array, int item)
	{
		int lo = 0;
		int hi = array.length-1;
		while(lo<=hi)
		{
			int mid = (lo+hi)/2;
			if(array[mid] < item)
			{
				lo = mid + 1;
			}
			else if(array[mid] > item)
			{
				hi = mid - 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}
}