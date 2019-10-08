import java.util.Scanner;
class JavaLoops {

    public static void main (String args[]) {

        int a = 1;  // Assign a starting value to variable 'a'

        // Demonstrating Usage of While Loop in Java
        // While loop is an entry controlled loop
        System.out.print("***** Using While Loop ****** ");
        System.out.println();
        // While the value of Variable a < = 10 do the condition in the loop body { do this }
        while( a <= 10) {
            System.out.println("Value of a : " + a); // While the loop condition is satisfied print value of 'a'
            a++; // Increment the value of 'a' for every iteration
        }

        // Demonstrating Usage of For Loop in Java
        // for loop is an entry controlled loop
        // Print the values that are in the range of the condition given in the loop.
        System.out.print("***** Using For Loop ****** ");
        System.out.println();
        for( a = 0 ; a<=10 ; a++ ) {
            System.out.println("Value of a : " + a); // While the loop condition is satisfied print value of 'a'
        }

        // adding do while loop
        // exit controlled loop
        System.out.print("***** Using Do While Loop ****** ");
        a=0;
        do{
            System.out.println("Value of a : " + a);
            a++;
        }while (a<=10);

        // for each loop example in java
        // majorly used with Maps and Sets
        System.out.print("***** Output Using forEach Loop ****** ");
        System.out.println();
        int inp[] = {1,2,3,4,5};
        // prints each element in the inp array
        for(int i : inp){
            System.out.println(i+" ");
        }

    }
}
