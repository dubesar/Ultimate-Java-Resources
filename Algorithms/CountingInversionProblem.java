import java.util.Scanner;

public class CountingInversionProblem {

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

		int totalInversions = countingInversionUsingMergeSort(numbers, 0, n - 1);
		System.out.println("No. Of Inversions are : " + totalInversions);

	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static int countingInversionUsingMergeSort(int arr[], int l, int r) {
		int inversionCount = 0;
		if (l < r) {
			int m = (l + r) / 2;

			inversionCount = countingInversionUsingMergeSort(arr, l, m);
			inversionCount = inversionCount + countingInversionUsingMergeSort(arr, m + 1, r);
			inversionCount = inversionCount + merge(arr, l, m, r);

		}
		return inversionCount;
	}

	static int merge(int arr[], int l, int m, int r) {
		int count = 0;
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[m + 1 + i];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;

			}

			else {
				arr[k] = R[j];
				count = count + (m + 1) - (l + i);
				j++;

			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return count;

	}

}
