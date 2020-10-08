public class insertionsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 99,-1, 100, 50, 29 };

		insrtionsort(arr);

	}

	public static void insrtionsort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {

					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		for (int k = 0; k <= 4; k++) {
			System.out.print(arr[k] + " ");

		}
	}
}
