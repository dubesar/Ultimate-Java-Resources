
class KadaneAlorithm{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[]){
        int n = arr.length;
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            localMax = Math.max(arr[i], localMax + arr[i]);
            if(localMax > globalMax){
                globalMax = localMax;
            }
        }
        return globalMax;
    }
