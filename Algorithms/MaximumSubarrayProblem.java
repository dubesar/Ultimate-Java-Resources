import java.util.*;

public class MaximumSubarrayProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of elements : ");
		int n = sc.nextInt();

		System.out.println("Enter " + n + " integers");
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {

			numbers[i] = sc.nextInt();
		}
		System.out.println("Given Array is ");
		printArray(numbers);

		int maxSum = maximumSubArraySum(numbers, 0, n - 1);
		System.out.println("Maximum SubArray Sum is : " + maxSum);

	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static int maximumSubArraySum(int[] arr, int l, int h) {
		if (l == h) {
			return arr[l];
		}

		int m = (l + h) / 2;

		return Math.max(maximumCrossingSum(arr, l, m, h),
				Math.max(maximumSubArraySum(arr, l, m), maximumSubArraySum(arr, m + 1, h)));
	}

	static int maximumCrossingSum(int[] arr, int l, int m, int h) {
		double negInf = Double.NEGATIVE_INFINITY;
		int sum = 0;
		int rightSum = (int) negInf;
		int leftSum = (int) negInf;
		for (int i = m; i >= l; i--) {
			sum = sum + arr[i];
			if (sum > leftSum)
				leftSum = sum;
		}
		sum = 0;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + arr[i];
			if (sum > rightSum)
				rightSum = sum;
		}
		return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));

	}
}
