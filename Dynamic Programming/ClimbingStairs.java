import java.util.Arrays;
public class ClimbingStairs{

static long[] memoization; 
public long numOfWays(int numOfSteps) {
     if(numOfSteps == 1 || numOfSteps == 0) 
       return 1;

     if (memoization[numOfSteps] != -1) 
       return memoization[numOfSteps]; 

     long currentResult = numOfWays(numOfSteps-2) + numOfWays(numOfSteps-1);
     memoization[numOfSteps] = currentResult;
     return currentResult;
 }
 
public static void main(String[] args) {
     ClimbingStairs sp = new ClimbingStairs();
     int steps = 4; //number of steps

     memoization = new long[steps+1];
     Arrays.fill(memoization, -1);

     System.out.println(sp.numOfWays(steps));
   }

}
