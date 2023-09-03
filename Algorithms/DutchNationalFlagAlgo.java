import java.util.Scanner;
public class DutchNationalFlagAlgo
{
    public static void sortColors(int[] nums) {
        int mid=0;
        int low=0;
        int high=nums.length - 1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else if (nums[mid]==1)
            {
                mid++;
            }
            else
            {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int []arr = new int[n];
	    for(int i=0;i<n;i++)
	    {
	        arr[i] = sc.nextInt();
	    }
	    sortColors(arr);
	    for(int i=0;i<n;i++)
	    {
	        System.out.print(arr[i]+" ");
	    }
	
	}
}
