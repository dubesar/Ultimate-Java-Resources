import java.util.HashMap;

/**
 * given an array of different coin sizes and a target amount you want to break down
 * in how many different ways can you break it down into coins?
 * Also every coin can only be used once
 * <p>
 * this solution assumes coin values are whole integers
 */

// using every coin once - how many different sets of coins do you have?
public class CoinChange {

    private static int howManySets(int[] arr, int target, HashMap<Integer, Integer> memo, int index) {
        // if we have done this calculation before just return the result
        if (memo.containsKey(target))
            return memo.get(target);

        if (index >= arr.length && target != 0) {
            return 0;
        }

        if (target - arr[index] >= 0) {
            // possibilities if we choose to include this coin value
            int possiblity1 = howManySets(arr, target - arr[index], memo, index + 1);
            if (!memo.containsKey(target - arr[index]))
                memo.put(target - arr[index], possiblity1);

            // and possibilities if we chose to skip this coin
            int possiblity2 = howManySets(arr, target, memo, index + 1);
            if (!memo.containsKey(target))
                memo.put(target, possiblity2);

            return possiblity1 + possiblity2;
        } else {
            int possiblity2 = howManySets(arr, target, memo, index + 1);
            if (!memo.containsKey(target))
                memo.put(target, possiblity2);
            return possiblity2;

        }


    }

    public static void main(String[] args) {
        //array of different coins we can use
        int[] arr = {2, 4, 6, 10, 8};
        
        int target = 12;

        // key - what is the target
        // value - how many sets
        HashMap<Integer, Integer> memo = new HashMap<>();

        //if the value is broken up and you are left with 0$ to break down -> there is only one possibility
        memo.put(0, 1);

        System.out.println(howManySets(arr, target, memo, 0));
    }
}
