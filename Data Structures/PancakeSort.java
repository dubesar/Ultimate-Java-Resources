import java.util.Arrays;

/**
 * @author Alessandro Arosio - 05/10/2020 18:35
 */
public class PancakeSort {

    public static void main(String[] args) {
        int[] result = pancakeSort(new int[]{-32, 41, 6, -2, 16, 0, 23});
        Arrays.stream(result).forEach(System.out::println);
    }

    static int[] pancakeSort(int[] arr) {
        int i = arr.length;
        int len = arr.length;
        while (i >= 0) {
            int pos = findGreatestElement(arr, 0, len);
            flip(arr, pos);
            flip(arr, len - 1);
            len--;
            i--;
        }
        return arr;
    }

    public static void flip(int[] arr, int k) {
        int i = 0;
        int j = k;
        while (i < k) {
            int tempArray = arr[j];
            arr[j] = arr[i];
            arr[i] = tempArray;
            i++;
            j--;
        }
    }

    public static int findGreatestElement(int[] arr, int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        int maxPosition = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] >= maxValue) {
                maxValue = arr[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }
}
