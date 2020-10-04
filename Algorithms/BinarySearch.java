import java.util.*;

class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Example array...
        int arr[] = {5, 10, 30, 37, 99, 239, 274, 590, 874, 1023};
        //asking the user to provide the number of queries to do in the above array.
        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();
        for(int i = 0; i < q; ++i) {
            //element input by user
            System.out.print("Enter number to search: ");
            int x = sc.nextInt();
            //checking wheter it is present in the array-arr
            if(binarySearch(arr, x)) {
                System.out.println(x + " is present in the array.");
            }else {
                System.out.println(x + " is not present in the array.");
            }
        }
    }
    
    //funtion to search any element present in the given array.
    public static boolean binarySearch(int arr[], int x) {
        //two pointers left and right which would come closer to the element to find.
        int left = 0, right = arr.length - 1, middle;

        while(left <= right) {
            //to check only the middle indexed element in the given array.
            middle = (left + right) / 2;
            if(arr[middle] == x) {
                return true;
            }else if(arr[middle] > x) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        //return false finally when there is no element x present in the given array.
        return false;
    }
}
