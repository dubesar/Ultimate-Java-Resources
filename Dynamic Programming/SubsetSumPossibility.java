import java.util.Arrays;

public class Subset {

    /**
    subsetSumPossible(@param set, @param sum) is a function to check if it is possible 
    to obtain the @param sum from the subset of integer array @param set.
    Returns true if it's possbile to obtain the @param sum from the subset or else returns false.
     */
    private static boolean subsetSumPossible(int[] set, int sum){
        int[][] table = new int[set.length+1][sum+1];
        for (int i=1; i<=set.length; i++){
            for(int s=0; s<=sum; s++){

                if (s==0){
                    table[i][s] = 1;
                }
                else if(s < set[i-1]){
                    table[i][s] = table[i-1][s];
                }
                else if(s == set[i-1]){
                    table[i][s] = 1;
                }
                else if(table[i-1][s] == 1){
                    table[i][s] = 1;
                }else{
                    table[i][s] = table[i-1][s - set[i-1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(table));
        return  table[set.length][sum] == 1;
    }
    public static void main(String[] args) {

        int[] set = {2, 3}; //{3, 34, 4, 12, 5, 2};
        int sum = 14; //14;
        if (subsetSumPossible(set, sum)){
            System.out.println("Subset is possibile");
        }else {
            System.out.println("Subset is not possibile");
        }
    }
}l̥