
import java.util.Scanner;

public class buy_sell_stocks {

	public static Scanner scn = new Scanner(System.in);     
/*In share trading, a buyer buys shares and sells on a future date. 
 * Given the stock price of n days, the trader is allowed to make at most k transactions,
 *  where a new transaction can only start after the previous transaction is complete, 
 *  find out the maximum profit that a share trader could have made.*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 2; 
        int[] price = { 10, 22, 5, 75, 65, 80 }; 
		System.out.println(maxprofit(price,k));
		
		
	}

	public static int maxprofit(int price[],int k){
		
		int ans[][]=new int[k+1][price.length];
		for(int i=0;i<k;i++){
			ans[i][0]=0;
		}
		
		for(int i=1;i<k+1;i++){
			for(int j=1;j<price.length;j++){
				
				ans[i][j] = ans[i][j-1];
				for(int p=0;p<=j-1;p++){
					ans[i][j]=Math.max(ans[i][j], ans[i-1][p]+price[j]-price[p]);
				}
			}
		}
		
		return ans[k][price.length-1];
	}
	
}
