import java.util.Arrays;

public class InsertionSort{

    public static void main (String args[]){
        int A[] = {9, 5, 4, 2, 1, 8, 7, 6};
        int x = A[0];
        for(int i = 0; i<A.length;i++){
            int j = i;
            while(j>0 && A[j]<A[j-1]){
                swap(A, j, j-1);
                j--;
                
            }
            System.out.println(Arrays.toString(A));
        }
    }

    public static void swap(int A[],int i,int m){
        int t = A[i];
        A[i] = A[m];
        A[m] = t;
        System.out.println(Arrays.toString(A));
    }
}