import java.util.Arrays;
import static java.lang.Math.min;

/**
    From the given set of coins find out the minimum number coins required to obtain the sum as totalAmount.
 */
public class MinimumCoins {

    /**
        minimumCoin(@param coins, @param totalAmount) calculates the minimum number coins required to obtain the 
        sum as @param totalAmount.
        Returns the minimum number of coins required.
     */
    public static int minimumCoin(int[] coins, int totalAmount){

        int[][] coinDistribution = new int[coins.length][totalAmount+1];

        for (int i=0;i<coins.length; i++){
            coinDistribution[i][0] = 0;
        }

        for(int i=0; i<coins.length;i++){

            for (int j=0; j<=totalAmount;j++){
                if (i == 0){
                    coinDistribution[i][j] = j;
                }else if (coins[i] > j){
                    //System.out.println("3" + i +":" +  j);
                    coinDistribution[i][j] = coinDistribution[i-1][j];
                }else {
                    coinDistribution[i][j] = min(coinDistribution[i-1][j],  1 + coinDistribution[i][j-coins[i]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(coinDistribution));
        return coinDistribution[coins.length-1][totalAmount];
    }
    public static void main(String[] args) {

        int[] coinsAvailable = {1,5,4,2,4,8};
        int totalAmount = 11;
        System.out.println(minimumCoin(coinsAvailable,totalAmount));
    }
}