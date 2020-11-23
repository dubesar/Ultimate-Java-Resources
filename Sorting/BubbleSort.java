package Sorting;

import java.util.Arrays;

/***************************************************
 * Sorts a array through BubbleSort(InsertionSort).
 *
 * @author https://github.com/AkMo3
 *
 **************************************************/
public class InsertionSort<E extends Comparable<E>> {

  public static void main(String[] args) {
    String[] a = {"Sachin", "Virat", "Bhuvi", "Jadeja", "Rohit", "Ashwin"};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  /**
   * Main method to sort the required array.
   *
   * @param a - array that is to be sorted.
   */
  public static void sort(Comparable[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - 1 - i; j++) {
        if (greater(a, j)) {
          swap(a, j);
        }
      }
    }
  }

  /**
   * Method to check whether element greater than the next.
   *
   * @param array - The array that is to be sorted.
   * @param index - index of position that is to be compared.
   */
  private static boolean greater(Comparable[] array, int index) {
    return array[index].compareTo(array[index + 1]) > 0;
  }

  /**
   * Method to swap positions of array.
   *
   * @param array - array in which array that is to be sorted
   * @param index - index that is to be swaped
   */
  private static void swap(Comparable[] array, int index) {
    Comparable temp = array[index];
    array[index] = array[index + 1];
    array[index + 1] = temp;
  }
}
