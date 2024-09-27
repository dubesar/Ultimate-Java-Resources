public class RadixSort {

    public static void sort(int[] arr) {
        int max = 0;
        int n = arr.length;

        for (int i = 0; i <= n - 1; i++)
            max = Math.max(max, arr[i]);

        double ceiling = Math.ceil(Math.log(max + 1) / Math.log(10));

        int p = 1;
        for (int j = 1; j <= ceiling; j++) {
            int[] count = new int[10];
            for (int i = 0; i <= n - 1; i++)
                count[(arr[i] / p) % 10] = count[(arr[i] / p) % 10] + 1;

            for (int i = 1; i <= 9; i++)
                count[i] = count[i - 1] + count[i];

            int[] output = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                output[count[(arr[i] / p) % 10] - 1] = arr[i];
                count[(arr[i] / p) % 10] = count[(arr[i] / p) % 10] - 1;
            }

            for (int i = 0; i <= n - 1; i++)
                arr[i] = output[i];

            p = p * 10;
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 12, 2, 3};
        int n = arr.length;

        System.out.print("Elements in array: ");
        printArr(arr);

        RadixSort radix = new RadixSort();
        radix.sort(arr);

        System.out.print("Sorted elements in array: ");
        printArr(arr);
    }
}
