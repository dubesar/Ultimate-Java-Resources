import java.util.Scanner;
class JavaLoops {

    public static void main (String args[]) {

        int a = 1;  // Assign a starting value to variable 'a' 

        // Demonstrating Usage of While Loop in Java
        System.out.print("***** Using While Loop ****** ");

        // While the value of Variable a < = 10 do the condition in the loop body { do this }
        while( a <= 10) {
            System.out.println("Value of a : " + a); // While the loop condition is satisfied print value of 'a'
            a++; // Increment the value of 'a' for every iteration
        }

        // Demonstrating Usage of For Loop in Java
        // Print the values that are in the range of the condition given in the loop.
        System.out.print("***** Using For Loop ****** ");
        for( a = 0 ; a<=10 ; a++ ) {
            System.out.println("Value of a : " + a); // While the loop condition is satisfied print value of 'a'
        }

    }
}
