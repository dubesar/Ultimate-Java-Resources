import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-->0){
		    String[] s = br.readLine().split(" ");
		    int n = Integer.parseInt(s[0]);
		    int k = Integer.parseInt(s[1]);
		    System.out.println(eggDropping(n, k));
		}
	}
	
	static int eggDropping(int n, int k){
	    int[][] table = new int[n+1][k+1];
	    for (int i=1; i<=n; i++){
	        table[i][1] = 1;
	    }
	    for (int i=1; i<=k; i++){
	        table[1][i] = i;
	    }
	    int res = 0;
	    for (int i=2; i<=n; i++){
	        for (int j=2; j<=k; j++){
	            table[i][j] = Integer.MAX_VALUE;
	            for (int x=1; x<=j; x++){
	                res = 1+Math.max(table[i][j-x], table[i-1][x-1]);
	                if (res<table[i][j])
	                    table[i][j] = res;
	            }
	        }
	    }
	    return table[n][k];
	}
}
