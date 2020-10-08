import java.util.*;
import java.lang.System;

public class Solution {
    
    public static int[] rotateArray(int[] arr, int d){
       
        int n = arr.length;
        int[] rotated = new int[n]; 
        
  
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        return rotated;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] numbers = new int[n];
        
 
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        
        
        numbers = rotateArray(numbers, d);
        
   
        for(int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    } 
 
}