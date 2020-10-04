import java.util.*;

public class Prefix_Sum {
    public static void main(String[] args) {

        Scanner fs = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        System.out.println("Enter 5 integer elements separated by spaces to be added in the list");

        for(int i=0 ; i<5 ; i++){
            int inp = fs.nextInt();
            list.add(inp);
        }

        List<Integer> prefixSumList = new ArrayList<>();

        for(int i=0 ; i<5 ; i++){
            if(i==0){

                /* first element of list is first element of prefix sum
                    list as there is no previous sum before it */

               prefixSumList.add(list.get(0));

            }else{

                /* Variable name used are self explanatory to
                   the idea of prefix sum array
                 */

                int currentValue = list.get(i);
                int previousSum = prefixSumList.get(i-1);

                int currentSum = currentValue + previousSum;

                // currentSum is the running sun till index i

                prefixSumList.add(currentSum);

            }
        }

        System.out.println("Printing the prefix sum for given input :- ");

        for(int i=0 ; i<5 ; i++){
            System.out.print(prefixSumList.get(i)+" ");
        }




    }
}
