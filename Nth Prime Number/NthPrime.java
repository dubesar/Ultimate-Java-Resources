// Java program to the nth prime number using Iteration
import java.util.Scanner;

public class NthPrime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Taking input
        int nth = sc.nextInt();

        int num, count, i;
        num=1;
        count=0;

        //This loop continues until the value
        // of the count is less than n.
        // If the condition is true then
        // it will increase the value of num by 1.
        while (count < nth){
            num=num+1;
            for (i = 2; i <= num; i++){
                if (num % i == 0) {
                    // if the number has a divisor other
                    // than 1 or itself, we break out of the loop
                    break;
                }
            }
            //The loop breaks and checks whether i is equal to num.
            // If it is so then the value of count is increased by 1
            // and then again checks the condition of while loop.
            //When the while loop terminates we get our final value in the variable num
            if ( i == num){
                count = count+1;
            }
        }
        System.out.println("Value of nth prime: " + num);
    }
}