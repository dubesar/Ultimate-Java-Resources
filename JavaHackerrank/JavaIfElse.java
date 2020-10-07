import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*; // Import
import java.util.regex.*;

public class Solution { //Declaring a class

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n % 2 != 0) { //If condition executes if this statement is correct
            System.out.println("Weird");
        } else if (n % 2 == 0 && n >= 2 && n <=5) { //executes if previous condition fails to execute and this statement is correct
            System.out.println("Not Weird");
        } else if (n % 2 == 0 && n >= 6 && n <= 20) { //executes if previous 2 conditions fail to execute and this statement is true
            System.out.println("Weird"); 
        } else if (n % 2 == 0 && n > 20) { //executes if previous 3 conditions fail to execute and this statement is true
            System.out.println("Not Weird");
        }
    }
}