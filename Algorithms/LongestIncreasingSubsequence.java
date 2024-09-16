

import java.util.Scanner;

class Main {
    static int findLIS(int arr[], int N)
    {
        // If No element, LIS is 0
        if(N == 0)
            return 0;
        //Intialize Array
        int lis[] = new int[N];


        // Minimum LIS is 1 when N>=1 as each element is in creasing order from itself.
        for (int i = 0; i < N; i++)
            lis[i] = 1;

        // Calculate LIS upto index 0, index 1 , index 2 ....... and so on upto N
        for (int i = 1; i < N; i++)
            for (int j = 0; j < i; j++)
                if ((arr[i] > arr[j] )&& (lis[i] < lis[j] + 1))
                    lis[i] = lis[j] + 1;

       //Find maximum value
        int max = 1;
        for (int i = 0; i < N; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    public static void main(String args[])
    {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int arr[] =new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();

        System.out.println("Maxmimum LIS is : " + findLIS(arr,N));
    }
}
